import java.util.Scanner;
class Palindrome
{
public static void main(String args[])
	{
		System.out.println("Enter any word");
		Scanner obj=new Scanner(System.in);
		String str=obj.next();
		String temp=str;
		int i=0;
		int j=str.length()-1;
		int flag=0;
		while(i<str.length() && j>=0)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				flag=1;
			}
			i++;
			j--;
		}
		if(flag==0)
		{
			System.out.println("Given word is palindrome");
			String str2="";
			for(i=0;i<str.length();i++)
			{
				if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||
				str.charAt(i)=='A'||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O'||str.charAt(i)=='U')
				{
					str2=str2.concat("edwin");
				}
				else
				{
					str2+=str.charAt(i);
				}
			}
			System.out.println(str2);
		}
		else
		{
			System.out.println("Given word is not palindrome!");
		}
	}
}