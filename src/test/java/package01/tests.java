package package01;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class tests extends TestBase {
    @Test
    public void test01() {
        //Test01:
        //1 amazon gidin
        driver.get("https://www.amazon.com");
        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(ddm);
        List<WebElement> ddmList=select.getOptions();
        for (WebElement each:ddmList
        ) {
            System.out.println(each.getText());
        }
        //3 drop down menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals(28,ddmList.size());

    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        //Test02
        //1 dropdown menuden elektronik bölümü seç in
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");

        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
        String sonucYazisi[]=
                driver.
                        findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                        getText().split("");

        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        //4 ikinci ürüne relative locater kullanarak tıklay in
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

    }

    @Test
    public void test03() {
        //Test03
        //1 yeni bir sekme açarak amazon a nasayfaya gid in
        //2 dropdown’dan bebek bölümüne secin
        //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4 sonuç yazsının puset içerdiğini te st edin
        //5 üçüncü ürüne relative locater kullanarak tıklay in
        //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in

    }

    @Test
    public void test04() {
        //Test 4
        //1 sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}
