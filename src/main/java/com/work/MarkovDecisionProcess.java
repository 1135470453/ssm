

import java.util.Scanner;

public class MarkovDecisionProcess {
    public static int chooseRandomly(int n, double[] p){
        double[] u = new double[n];
        u[0]=p[0];
        for (int i =1;i<n;i++){
            u[i]=u[i-1]+p[i];
        }
        double x = Math.random();
        for (int i=0;i<n;i++){
            if (x<u[i]){
                return i;
            }
        }
        return n-1;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstline = input.nextLine();
        String [] fl = firstline.split(" ");
        int n = Integer.valueOf(fl[0]);
        int t = Integer.valueOf(fl[1]);
        int round = Integer.valueOf(fl[2]);
        int frequency = Integer.valueOf(fl[3]);
        int M = Integer.valueOf(fl[4]);
        int[] rewords = new int[t];
        for (int i=0;i<t;i++){
            int a = input.nextInt();
            rewords[i] = input.nextInt();
        }
        String line = input.nextLine();
        line = "1";
        String thirdline = "";
        int[] numberOfAction = new int[n];
        for (int a:numberOfAction){
            a = 0;
        }
        while (line.compareTo("")!=0){
            line = input.nextLine();
            if (line.compareTo("")!=0){
                String[] tl = line.split(":");
                numberOfAction[Integer.valueOf(tl[0])]++;
                thirdline += tl[1];
                thirdline += "a";
            }
        }
        double [][][] pOfNextState = new double[n][][];
        for (int i=0;i<n;i++){
            pOfNextState[i] = new double[numberOfAction[i]][n+t];
        }
        String[] pl = thirdline.split("a");
        int j = 0;
        for (double[][] a:pOfNextState){
            for (double[] b:a){
                for (double c:b){
                    c=0;
                }
            }
        }
        for (double[][] a:pOfNextState){
            for (double[] b:a){
                String[] ppl = pl[j].split(" ");
                for (int i =1;i<ppl.length;i++){
                    b[Integer.valueOf(ppl[i])] = Double.valueOf(ppl[++i]);
                }
                j++;
            }
        }
        int s;
        double[] pOfN = new double[n];
        for (double p:pOfN){
            p = (double) 1/n;
        }
        int[][] count = new int[n][];
        int[][] total = new int[n][];
        for (int i=0;i<n;i++){
            count[i] = new int[numberOfAction[i]];
            for (int a:count[i]){
                a=0;
            }
            total[i] = new int[numberOfAction[i]];
            for (int a:total[i]){
                a=0;
            }
        }
        for(int around=0;around<round;around++){
            s = chooseRandomly(n,pOfN);
            int[][] aAcount = new int[n][];
            for(int i=0;i<n;i++){
                aAcount[i] = new int[numberOfAction[i]];
            }
            for (int a[]:aAcount){
                for (int b:a){
                    b=0;
                }
            }
            while (s<n){
                int action;
                int[] type = new int[n];
                for (int a:type){
                    a=0;
                }
                int k=0;
                j=0;
                for (int i=0;i<count[s].length;i++){
                    if (count[s][i]==0){
                        type[j++]=i;
                        k++;
                    }
                }
                if (k>0){
                    double[] p = new double[j];
                    for (double a:p){
                        a=(double) 1/j;
                    }
                    action = type[chooseRandomly(j,p)];
                }else {
                    double[] avg = new double[numberOfAction[s]];
                    for (int i=0;i<numberOfAction[s];i++){
                        avg[i] = (double) total[s][i]/count[s][i];
                    }
                    int bottom = 0,top = 0;
                    for (int i=0;i<rewords.length;i++){
                        if (i==0){
                            bottom = rewords[0];
                            top = rewords[0];
                        }else {
                            if (bottom>rewords[i]){
                                bottom = rewords[i];
                            }
                            if (top<rewords[i]){
                                top = rewords[i];
                            }
                        }
                    }
                    double[] savg = new double[numberOfAction[s]];
                    for (int i=0;i<numberOfAction[s];i++){
                        savg[i] = 0.25+0.75*(avg[i]-bottom)/(top-bottom);
                    }
                    double c=0;
                    for (double a:savg){
                        c+=a;
                    }
                    double[] up = new double[numberOfAction[s]];
                    for (int i=0;i<numberOfAction[s];i++){
                        up[i] = Math.pow(savg[i],c/M);
                    }
                    double norm = 0;
                    for (double a:up){
                        norm+=a;
                    }
                    double [] pOfA = new double[numberOfAction[s]];
                    for (int i=0;i<numberOfAction[s];i++){
                        pOfA[i] = up[i]/norm;
                    }
                    action = chooseRandomly(numberOfAction[s],pOfA);
                }
                aAcount[s][action]++;
                s = chooseRandomly(n+t,pOfNextState[s][action]);
            }
            for (int q=0;q<n;q++){
                for (int w=0;w<numberOfAction[q];w++){
                    if (aAcount[q][w]>0){
                        count[q][w]++;
                        total[q][w]+=rewords[s-n];
                    }
                }
            }
            if(frequency!=0){
                if ((around+1)%frequency==0&&(around+1)!=round){
                    System.out.println("\nAfter "+(around+1)+" rounds");
                    System.out.println("Count:");
                    for (int q=0;q<n;q++){
                        for (int w=0;w<numberOfAction[q];w++){
                            System.out.print("["+q+","+w+"]="+count[q][w]+". ");
                        }
                        System.out.println("");
                    }
                    System.out.println("\nTotal:");
                    for (int q=0;q<n;q++){
                        for (int w=0;w<numberOfAction[q];w++){
                            System.out.print("["+q+","+w+"]="+total[q][w]+". ");
                        }
                        System.out.println("");
                    }
                    System.out.print("\nBest action: ");
                    for (int q=0;q<n;q++){
                        System.out.print(q+":");
                        double best=-1;
                        int numOfBest=-1;
                        for (int w=0;w<numberOfAction[q];w++){
                            if (count[q][w]==0){
                                numOfBest = -1;
                                System.out.print("U. ");
                                break;
                            }
                            if (best < (double) total[q][w]/count[q][w]){
                                best = (double)total[q][w]/count[q][w];
                                numOfBest = w;
                            }
                        }
                        if (numOfBest!=-1){
                            System.out.print(numOfBest+". ");
                        }
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("\nAfter "+round+" rounds");
        System.out.println("Count:");
        for (int q=0;q<n;q++){
            for (int w=0;w<numberOfAction[q];w++){
                System.out.print("["+q+","+w+"]="+count[q][w]+". ");
            }
            System.out.println("");
        }
        System.out.println("\nTotal:");
        for (int q=0;q<n;q++){
            for (int w=0;w<numberOfAction[q];w++){
                System.out.print("["+q+","+w+"]="+total[q][w]+". ");
            }
            System.out.println("");
        }
        System.out.print("\nBest action: ");
        for (int q=0;q<n;q++){
            System.out.print(q+":");
            double best=-1;
            int numOfBest=-1;
            for (int w=0;w<numberOfAction[q];w++){
                if (count[q][w]==0){
                    numOfBest = -1;
                    System.out.print("U. ");
                    break;
                }
                if (best < (double) total[q][w]/count[q][w]){
                    best = (double)total[q][w]/count[q][w];
                    numOfBest = w;
                }
            }
            if (numOfBest!=-1){
                System.out.print(numOfBest+". ");
            }
        }
        System.out.println("");
        }
    }
