package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name="Data")
    public String[][] getAllData() throws IOException{
        String path=System.getProperty("user.dir")+"//TestData//UserData.xlsx";
        XLUtility x1=new XLUtility(path);

        int rownum= x1.getRowCount("Sheet1");
        int colcount=x1.getCellCount("Sheet1",1);

        String apidata[][] =new String[rownum][colcount];

        for(int i=1;i<=rownum;i++){
            for(int j=0;j<colcount;j++)
            {
                apidata[i-1][j]=x1.getCellData("Sheet1",i,j);

            }
        }
        return apidata;
    }

    @DataProvider(name="UserNames")
    public String[] getUserNames() throws IOException{

        String path=System.getProperty("user.dir")+"//TestData//UserData.xlsx";
        XLUtility x1=new XLUtility(path);

        int rownum=x1.getRowCount("Sheet1");

        String apidata[]=new String[rownum];

        for(int i=1;i<=rownum;i++){
            apidata[i-1]=x1.getCellData("Sheet1", i, 1);
        }
        return apidata;
    }

}
