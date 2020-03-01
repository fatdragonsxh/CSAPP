package P1;
import java.io.*;

public class MagicSquare {
    static boolean isLegalMagicSquare(String fileName) {
    	String line=null;
    	int row=0;
    	int list=0;
    	int i=0;
    	int j=0;
    	int listcounter=0;
    	boolean flag=false;
    	File file=new File(fileName);
    	try {
    		BufferedReader breader1=new BufferedReader(new FileReader(file));
    		line=breader1.readLine();
    		String[] listreader=line.split("\t");
    		list=listreader.length;//get lists now
    		while(line!=null) {
    			row++;
    			line=breader1.readLine();//get the sum of lines
    		}
    		breader1.close();//now get row
    		if(row!=list)
    		{
    			System.out.println("not a Square");
    			return false;//list!=row not a Square
    		}
    		breader1.close();
    		int[][] Square=new int[row][list];
    		BufferedReader breader2=new BufferedReader(new FileReader(file));
    		while((line=breader2.readLine())!=null) {
    			String[] numvalue=line.split("\t");
    			if(numvalue.length!=row)
    			{
    				for(i=0;i<numvalue.length;i++)
    				{
    					if(numvalue[i].contains(" "))
    					{
    						flag=true;
    					}
    				}
    				if(flag)
    				{
    					System.out.println("not divided by table");
    				}
    				else {
    					System.out.println("absence of number");
    				}
    				return false;
    			}
    			for(j=0;j<numvalue.length;j++) {
    				for(i=0;i<numvalue[j].length();i++) {
    					if(!Character.isDigit(numvalue[j].charAt(i))) {
    						System.out.println("illegal number");//check if a legal number
    						return false;
    					}
        			}
    				Square[listcounter][j]=Integer.valueOf(numvalue[j]);
    			}
    			listcounter++;
    		}
    		int[] rowSum=new int[row];
    		int[] listSum=new int[list];
    		for(i=0;i<list;i++) {
    			for(j=0;j<list;j++) {
    				rowSum[i]=rowSum[i]+Square[i][j];
    				listSum[j]=listSum[j]+Square[j][i];
    			}
    		}
    		int leftline=0;
    		int rightline=0;
    		for(i=0;i<row;i++) {
    			leftline=leftline+Square[i][i];
    			rightline=rightline+Square[row-i-1][row-i-1];
    		}
    		for(i=0;i<row-1;i++)
    		{
    			if(rowSum[i]!=rowSum[i+1]) {
    				System.out.println("not equal");
    				return false;
    			}
    			if(listSum[i]!=listSum[i+1]) {
    				System.out.println("not equal");
    				return false;
    			}
    		}
    		if(listSum[0]!=rowSum[0]||leftline!=rightline||leftline!=listSum[0]) {
    			System.out.println("not equal");
    			return false;
    		}
    		breader2.close();
    	}catch(IOException e) {
    		System.out.println("fail to open");
    		return false;
    	}
    	return true;
    }
    
    public static boolean generateMagicSquare(int n) {
    	if(n<=0||n%2==0) {
    		System.out.println("illegal number");
    		return false;
    	}
    	int magic[][]=new int[n][n];
    	int row=0,col=n/2,i=0,j=0,square=n*n;
    	for(i=1;i<=square;i++) {
    		magic[row][col]=i;
    		if(i%n==0)
    		{
    			row++;
    		}
    		else {
    			if(row==0) {
    				row=n-1;
    			}
    			else {
    				row--;
    			}
    			if(col==(n-1))
    			{
    				col=0;
    			}
    			else
    				col++;
    		}
    	}
    	String filename="src/P1/txt/6.txt";
    	try {
    		File fname=new File(filename);
    		fname.createNewFile();
    		BufferedWriter bwriter=new BufferedWriter(new FileWriter(fname));
    		for(i=0;i<n;i++) {
    			for(j=0;j<n;j++) {
    				bwriter.write(magic[i][j]+"\t");
    			}
    			bwriter.newLine();
    		}
    		bwriter.close();
    	}catch(IOException e) {
    		System.out.println("can not creat");
    		return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a,b,c,d,e,f,g;
		a = isLegalMagicSquare("src/P1/txt/1.txt");
		System.out.println(a);
		b = isLegalMagicSquare("src/P1/txt/2.txt");
		System.out.println(b);
		c = isLegalMagicSquare("src/P1/txt/3.txt");
		System.out.println(c);
		d = isLegalMagicSquare("src/P1/txt/4.txt");
		System.out.println(d);
		e = isLegalMagicSquare("src/P1/txt/5.txt");
		System.out.println(e);
		f=generateMagicSquare(-1);
		f=generateMagicSquare(2);
		f=generateMagicSquare(5);
		g=isLegalMagicSquare("src/P1/txt/6.txt");
		System.out.println(g);
		
	}

}
