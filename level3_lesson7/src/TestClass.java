public class TestClass {

    @BeforeSuite
    public void firstMethod() {
        System.out.println("Before Tests");
    }

    @Test(priority = 10)
    public void doTest1() {
        System.out.println("Test1");
    }

    @Test(priority = 1)
    public void doTest2() {
        System.out.println("Test2");
    }

    @Test()
    public void doTest3() {
        System.out.println("Test3");
    }

    @AfterSuite
    public void lastMethod() {
        System.out.println("After Tests");
    }

}
