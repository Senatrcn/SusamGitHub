package amazonTestPackage;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Amazon_GenelTekrar extends TestBase {
        /*
        Test01 :
            1- amazon gidin
            2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
            3- dropdown menude 28 eleman olduğunu doğrulayın
            Test02
            1- dropdown menuden elektronik bölümü seçin
            2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
            3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
            4- ikinci ürüne relative locater kullanarak tıklayin
            5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
            Test03
            1- yeni bir sekme açarak amazon anasayfaya gidin
            2-dropdown’dan bebek bölümüne secin
            3-bebek puset aratıp bulundan sonuç sayısını yazdırın
            4-sonuç yazsının puset içerdiğini test edin
            5-üçüncü ürüne relative locater kullanarak tıklayin
            6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
            Test 4
            1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
            */

    static WebElement dropdownMenu;
    static Select dropdownSelect;

    @Test
    public void test01(){
        //1- amazon gidin
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //3- dropdown menude 57 eleman olduğunu doğrulayın
        driver.get("https:www.amazon.com");
        dropdownMenu = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        dropdownSelect = new Select(dropdownMenu);
        Assert.assertEquals(dropdownSelect.getOptions().size(), 28);

        //  1- dropdown menuden elektronik bölümü seçin
        //  2 - arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        // 4- ikinci ürüne relative locater kullanarak tıklayin
        // 5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        //dropdownSelect.getOptions().stream().forEach(t->System.out.println(t.getText()));
        dropdownSelect.selectByVisibleText("Electronics");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER) ;
        String actualSonucYazisi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String expectedSonucYazisi = "iphone";
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement ikinciUrunResmi = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ilkUrunResmi));
        Actions actions = new Actions(driver);
        actions.click(ikinciUrunResmi).perform();
        System.out.println("Urun title :" + driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText());
        driver.findElement(By.xpath("//a[@title='Add to List']")).click(); //Ürünü List'e ekle.

        /*
            1- yeni bir sekme açarak amazon anasayfaya gidin
            2-dropdown’dan bebek bölümüne secin
            3-bebek puset aratıp bulundan sonuç sayısını yazdırın
            4-sonuç yazsının puset içerdiğini test edin
            5-üçüncü ürüne relative locater kullanarak tıklayin
            6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
         */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        dropdownMenu = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        dropdownSelect = new Select(dropdownMenu);
        //dropdownSelect.getOptions().stream().forEach(t->System.out.println(t.getText()));
        dropdownSelect.selectByVisibleText("Baby");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puset" + Keys.ENTER) ;
        WebElement ikinciUrunWebElement = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        WebElement birinciUrunWebElement = driver.findElement(RelativeLocator.with(By.tagName("img")).above(ikinciUrunWebElement));
        birinciUrunWebElement.click();
    }
}
