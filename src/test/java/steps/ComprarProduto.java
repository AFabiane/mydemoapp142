package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ComprarProduto {

    private AndroidDriver driver;
    
    private URL getUrl() {
        try {
            return new URL(
                    "https://oauth-fabisn1987-844a4:dbb8f3d4-3e95-4bac-b22a-a67382ff052b@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Before
    public void iniciar() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:platformVersion", "9.0")
                .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
                .amend("appium:deviceOrientation", "portrait")
                .amend("appium:app", "storage:filename=mda-2.2.0-25.apk")
                .amend("appium:appPackage", "com.saucelabs.mydemoapp.android")
                .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                .amend("appium:automationName", "UiAutomator2")
                .amend("browserName", "")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);
        // esta linha instancia o Appium e abre o aplicativo
        driver = new AndroidDriver(this.getUrl(), options);
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Dado("que acesso o My Demo App")
    public void que_acesso_o_my_demo_app() {
        // o app foi aberto no final do método iniciar (Before)
    }

    @E("verifico o logo e o nome da secao")
    public void verifico_o_logo_e_o_nome_da_secao() {
        var imgLogo = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/mTvTitle"));
        assertEquals(imgLogo.isDisplayed(), true);

        var lblTituloSecao = driver.findElement(AppiumBy.id(""));
        assertEquals("Products", lblTituloSecao.getText());
    }

    @E("localizo o <produto> que esta por <preco>")
    public void localizo_o_produto_que_esta_por_preco() {
        // Home
        //produto :
        //preco   :

    }

    @Quando("clico na imagem do <num_produto>")
    public void clico_na_imagem_do_num_produto() {

    }

    @Entao("na tela do produto verifico o <produto> e o <preco>")
    public void na_tela_do_produto_verifico_o_produto_e_o_preco() {


    }

    @Quando("arrasto para cima e clico no botao Add Cart")
    public void arrasto_para_cima_e_clico_no_botao_add_cart() {
        // Tela do Produto
        // botao adicionar no carrinho:
    }

    @Entao("na tela do carrinho verifico o <produto> <preco> e <quantidade>")
    public void na_tela_do_carrinho_verifico_o_produto_preco_e_quantidade() {
        // Carrinho
        //produto :
        //preco   :
        //quant   :
    }

}