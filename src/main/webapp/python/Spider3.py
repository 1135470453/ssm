import pandas as pd
import requests
import random
from bs4 import BeautifulSoup
import pymysql
from sqlalchemy import create_engine
# 正常运行


def get_one_page(code):
    # 使用ip代理,随机代理ip
    # 设置headers 这些都是为了避免访问过于频繁被禁止
    try:
        IPs = [{'HTTP': 'HTTP://118.190.95.35:9001'},
               {'HTTP': 'HTTP://61.135.217.7:80'},
               {'HTTP': 'HTTP://116.1.11.19:80'}]
        reportTime = '2017-12-31'
        headers = {
            #'User-Agent'略有不同
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36',
            'Referer': 'https://s.askci.com/stock/financialreport/689009/'
        }
        url = 'https://s.askci.com/stock/financialreport/%s' % code
        response = requests.get(url, headers=headers, proxies=random.choice(IPs))
        response.encoding = 'utf-8'
        if response.status_code == 200:
            return response.text
        return None
    except requests.RequestException:
        print("爬取出错")


def parse_one_page(html):
    soup = BeautifulSoup(html, 'lxml')
    # [soup.extract() for img in soup("img")]
    # print(type(soup))
    # 选择id为myTable01的控件，代码中有解释
    content = soup.select("#myTable01")[0]
    # print(content)


    # print(type(content))
    # print(content)


    # 第一行设置为column,并且选第一个(因为是一个list), 其实也只有一个
    tbl = pd.read_html(content.prettify(), header=0)[0]  # prettify()是美化文本的作用

    # 强制修改列名，中文列名不好写入数据库
    tbl.columns = ['MetricPerYear', '2020_03_31', '2019_12_31', '2018_12_31', '2017_12_31', '2016_12_31', '2015_12_31', '2014_12_31', '2013_12_31', '2012_12_31']

    # tbl.columns = ['MetricPerYear', '2020-09-30', '2019-12-31', '2018-12-31', '2017-12-31', '2016-12-31', '2015-12-31', '2014-12-31', '2013-12-31', '2012-12-31']
    # print(tbl)
    return tbl


def generate_mysql(db, user, password, port, code):
    # 创立连接
    # db就是需要数据库中的schema 选一个schema就好了
    conn = pymysql.connect(
        host='localhost',
        user=user,
        password=password,
        port=port,
        charset='utf8',
        db=db
    )
    cursor = conn.cursor()
    # 创建数据库
    sql = 'CREATE DATABASE if not exists %s' % db
    # 执行命令
    cursor.execute(sql)

    # 创建表
    # sql = 'CREATE TABLE if not exists listed_data3 (MetricPerYear varchar(100) NOT NULL, 2020_09_30 VARCHAR(20), date2 VARCHAR(20), date3 VARCHAR(20), date4 VARCHAR(20), date5 VARCHAR(20), date6 VARCHAR(20), date7 VARCHAR(20), date8 VARCHAR(20), date9 VARCHAR(20), primary key(MetricPerYear))'
    sql = 'CREATE TABLE if not exists company_data_%s(MetricPerYear varchar(100) NOT NULL, 2020_09_30 VARCHAR(20), 2019_12_31 VARCHAR(20), 2018_12_31 VARCHAR(20), 2017_12_31 VARCHAR(20), 2016_12_31 VARCHAR(20), 2015_12_31 VARCHAR(20), 2014_12_31 VARCHAR(20), 2013_12_31 VARCHAR(20), 2012_12_31 VARCHAR(20), primary key(MetricPerYear))' % code
    # constraint fk_Data foreign key(MetricPerYear) references listed_company(stock_code)
    # 执行命令"2019-12-31"
    cursor.execute(sql)

    # 断开链接
    conn.close()


def write_to_sql(tbl, db, user, password, port, code):
    engine = create_engine('mysql+pymysql://%s:%s@localhost:%d/%s?charset=utf8' % (user, password, port, db))

    # if_exists='replace'可以保证按网站所列数据顺序写入数据库
    tbl.to_sql('company_data_%s' % code, con=engine, if_exists='replace', index=False )


def main(code):
    # 设置预想database
    db = 'ee'
    user = 'root'
    password = 'root'
    port = 3306
    # 生成数据库，创建表项
    generate_mysql(db, user, password, port, code)
    html = get_one_page(code)
     # 分析得到dataframe
    tbl = parse_one_page(html)
    # 将dataframe写到sql中
    write_to_sql(tbl, db, user, password, port, code)


if __name__ == '__main__':

    stock_code = '000046' # 此处传入参数
    # 最大设置为178,输入页数就好了
    main(stock_code)