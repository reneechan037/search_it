package Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import Model.Manager.*;
import Model.user.*;
import Model.Login.*;
import Model.Register.*;
import Model.Cache.*;
public class testAccountManager {
	//register
	@Test
	public void test_AccountManager_1() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test2","test2","test2",new Staff());
		Response r = am.registerAccount(u);
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_2() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test3","test3","test3",new Manager());
		Response r = am.registerAccount(u);
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_3() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test2","test2","test2",new Staff());
		Response r = am.registerAccount(u);
		assertEquals(false, r.getResult());
	}
	@Test
	public void test_AccountManager_4() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Client("client2","client2","client2");
		Response r = am.registerAccount(u);
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_5() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Client("client2","client2","client2");
		Response r = am.registerAccount(u);
		assertEquals(false, r.getResult());
	}
	//login
	@Test
	public void test_AccountManager_6() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("test2","test2");
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_7() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("client2","client2");
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_8() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("cli","client2");
		assertEquals(false, r.getResult());
	}
	@Test
	public void test_AccountManager_9() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("","client2");
		assertEquals(false, r.getResult());
	}
	@Test
	public void test_AccountManager_10() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("","");
		assertEquals(false, r.getResult());
	}
	@Test
	public void test_AccountManager_11() throws Exception {
		AccountManager am = AccountManager.getInstance();
		Response r = am.loginAccount("ccc","");
		assertEquals(false, r.getResult());
	}
	//logout
	@Test
	public void test_AccountManager_12() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Client("client2","client2","client2");
		Response r = am.logoutAccount(u);
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_13() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Client("test2","test2","test2");
		Response r = am.logoutAccount(u);
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_14() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test2","test2","test2",new Manager());
		Response r = am.logoutAccount(u);
		assertEquals(true, r.getResult());
	}
//	@Test
//	public void test_AccountManager_14() throws Exception {
//		AccountManager am = AccountManager.getInstance();
//		User u = new Client("qq","test2","test2");
//		Response r = am.logoutAccount(u);
//		assertEquals(false, r.getResult());
//	}
//	@Test
//	public void test_AccountManager_15() throws Exception {
//		AccountManager am = AccountManager.getInstance();
//		User u = new Client("","test2","test2");
//		Response r = am.logoutAccount(u);
//		assertEquals(false, r.getResult());
//	}
	//registerService with accountManager
	@Test
	public void test_AccountManager_18() throws Exception {
		RegisterService rs = new RegisterService();
		Response r = rs.register("test7", "test7");
		assertEquals(true, r.getResult());
	}
	
	//get user by user id
	@Test
	public void test_AccountManager_16() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test4","test4","test4",new Manager());
		am.registerAccount(u);
		am.loginAccount("test4", "test4");
		User u2 = am.getUserByUserId("USER6");
		assertEquals(u, u2);
	}
	@Test
	public void test_AccountManager_17() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test6","test6","test6",new Staff());
		User u2 = am.getUserByUserId("tes");
		assertEquals(null, u2);
	}
	//loginService with AccountManager
	@Test
	public void test_AccountManager_19() throws Exception {
		LoginService ls = new LoginService();
		Response r = ls.login("test7", "test7");
		assertEquals(true, r.getResult());
	}
	@Test
	public void test_AccountManager_20() throws Exception {
		LoginService ls = new LoginService();
		Response r = ls.logout();
		assertEquals(true, r.getResult());
	}
}
