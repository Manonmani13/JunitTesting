package com.sample;

public class PalindromeCheck {
	public boolean isPalindrome(String args) {
		String reverse="";
		int length=args.length();
		for(int i=length-1;i>=0;i--)
		{
			reverse+=args.charAt(i);
		}
		if(reverse.equals(args))
		{
			return true;
		}
		else {
			return false;
		}
	}

	
}
