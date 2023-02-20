package Tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "userList")
    public static Object[][] getDataFromDataprovider() {

        return new Object[][] {
                { "Jon", "Snow", "knownothing@gmail.com", "30", "3000", "alpha" },
                { "Buttercup", "cumbersnatch", "BudapestCandygram@mail.io", "41", "2000", "beta" },
        };

    }

}
