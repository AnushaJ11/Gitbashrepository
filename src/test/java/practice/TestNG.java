package practice;

import org.testng.annotations.Test;

public class TestNG {

	
		@Test
		
		public void createProduct()
		{
			System.out.println("product created");
		}
		@Test(invocationCount =3)
		public void modifyproduct()
		{
			System.out.println("modify product");
		}
		@Test(enabled = false)
		public void deleteproduct()
		{
			System.out.println("delete product");
		}
	}


