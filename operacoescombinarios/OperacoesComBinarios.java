package operacoescombinarios;
/**
 *
 * @author Henk Beula
 */
import java.util.Scanner;
public class OperacoesComBinarios {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       /* //Adicao de numeros binarios
        System.out.println("********************************");
        System.out.println("#Adicao de numeros Binarios#");
        long bin1,bin2;
        int i=0,remainder=0;
       int[] sum= new int[20];
       System.out.print("Introduza um numero Binario: ");
       bin1=sc.nextInt();
       System.out.print("Introduza outro numero Binario: ");
       bin2=sc.nextInt();
       while(bin1!=0 || bin2!=0){
           sum[i++] = (int) ((bin1 % 10 + bin2 % 10 + remainder) % 2);
           remainder = (int) ((bin1 % 10 + bin2 % 10 + remainder) / 2);
           bin1 = bin2 / 10;
           bin2 = bin2 / 10;
       }
       if(remainder !=0){
           sum[i++]  = remainder;
       }
       --i;
       System.out.print("Soma dos dois numeros binarios e: ");
       while(i>=0){
           System.out.print(sum[i--]);
       }
       System.out.print("\n");
       System.out.println("********************************");
       
        //Multiplicacao de binarios
        //long binary1,binary2;
        
        //Conversao decimal-binario
        System.out.print("\n");
        System.out.println("********************************");
        System.out.println("#Conversao decimal-Hexadecimal#");
        int decimal=5,controler,y=1,j;
        int binary[]=new int[100];
        
        controler=decimal;
        
        while(controler>0){
            binary[y++] = controler%2;
            controler = controler/2;
        }
        
        System.out.print(decimal+" em binario e igual a = ");
        for(j=y-1;j>0;j--)
            System.out.print(binary[j]);
        System.out.print("\n");
        System.out.println("********************************");
        System.out.print("\n");
        
        //Conversao Decimal-Hexadecimal
        System.out.println("********************************");
        System.out.println("#Conversao decimal-Hexadecimal#");
        int dec_num,remindr;
        String hex_num="";
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        System.out.print("Introduza um numero decimal: ");
        dec_num=sc.nextInt();
        
        while(dec_num>0){
            remindr=dec_num%16;
            hex_num=hex[remindr]+hex_num;
            dec_num=dec_num/16;
        }
            System.out.print("O numero em Hexadecimal e:"+hex_num+"\n");
            System.out.println("********************************");
              
        //Conversao decimal-octal
        System.out.println("\n");
        System.out.println("********************************");
        System.out.println("#Conversao decimal-octal#");
        int num_dec,x=1,octal_num[]= new int[100];
        int rem;
        System.out.print("Introduza um numero decimal: ");
        num_dec=sc.nextInt();
        rem=num_dec;
            while(rem!=0){
                octal_num[x++]=rem%8;
                rem=rem/8;
            }
            System.out.print("O numero "+num_dec+" em octal e: ");
            for(int g=x-1;g>0;g--)
                System.out.print(octal_num[g]);
        System.out.println("\n"+"********************************");*/
        
        //Conversao binario-decimal
        System.out.println("\n");
        System.out.println("********************************");
        System.out.println("#Conversao binario-decimal#");
        int binNum=0,i=0,Bins[]=new int[100];
        System.out.print("Introduza um numero binario");
        while(binNum>=0){
            binNum=sc.nextInt();
            Bins[i++]=binNum;
        }
        for(int j=1;j<Bins.length;j++)
            System.out.print(Bins[j]);
        System.out.println("\n"+"********************************");
        
    }
    
}
