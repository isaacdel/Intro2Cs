
public class RecursionMystery {
	public static int mystery1(int n){

		if(n==0||n==1)
			return n;
		else
			return	mystery1(n-1)+mystery1(n-2);
	}

	public static void mysteryHelper(int N, int[] res, int len){

		if(N==0) 
			return;

		res[--len] = N%2;

		mysteryHelper(N/2, res, len);
	}



	public static void mystery2(int N, int[] res){
		mysteryHelper(N, res, res.length);
	}
}
