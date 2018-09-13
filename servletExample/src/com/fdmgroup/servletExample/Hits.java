package com.fdmgroup.servletExample;

public class Hits {
	private static int hitCount = 0;
	
	public static void incrementHit()
	{
		setHitCount(Hits.getHitCount() + 1);
	}
	
	public static void decrementHit()
	{
		setHitCount(Hits.getHitCount() - 1);
	}

	public static int getHitCount() {
		return hitCount;
	}

	public static void setHitCount(int hitCount) {
		Hits.hitCount = hitCount;
	}	

}
