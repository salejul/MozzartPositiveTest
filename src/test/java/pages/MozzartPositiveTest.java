package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import tests.BaseClass;

public class MozzartPositiveTest extends BaseClass {

	@Test
	public void positiveTest() {

		///////////////////////////////////////////////////////////

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement loginScreen = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/action_login")));

		loginScreen.click();

		/////////////////////////////////////////
		////// APPROVE THE LOCATION SETTINGS//////

		WebElement location = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/button1")));

		location.click();

		WebElement locationPerm = wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")));

		locationPerm.click();

		//////////////////////////////////////////
		////// LOGIN WITH CORRECT CREDENTIALS/////

		WebElement loginEmail = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/email")));

		loginEmail.click();

		loginEmail.sendKeys("marija.sum");

		driver.navigate().back();

		WebElement loginPass = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/password")));

		loginPass.click();

		loginPass.sendKeys("marija!");

		driver.navigate().back();

		WebElement rememberMeCheckBox = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/remember_me")));

		rememberMeCheckBox.click();

		WebElement loginClickButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/login")));

		loginClickButton.click();

		/////////////////////////////////////////
		////// BETTING PROCESS///////////////////

		WebElement liveBetClick = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView\r\n"
						+ "")));

		liveBetClick.click();
		
		

		WebElement firstMatch = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")));

		if (firstMatch.isEnabled())
			firstMatch.click();
		else {
			WebElement secondMatch = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")));

			secondMatch.click();
		}
		
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
        Interaction moveToStart = finger.createPointerMove(Duration.ZERO, Origin.viewport(), 520, 1530);
        Interaction pressDown = finger.createPointerDown(MouseButton.LEFT.asArg());
        Interaction moveToEnd = finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), 520, 490);
        Interaction pressUp = finger.createPointerUp(MouseButton.LEFT.asArg());

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);

        driver.perform(Arrays.asList(swipe));


		WebElement thirdMatch = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")));

		thirdMatch.click();

		WebElement arrow = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")));

		arrow.click();

		WebElement amount = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/amount")));

		amount.clear();

		amount.sendKeys("20");

		amount.click();

		WebElement acceptHigher = wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/accept_higher")));

		acceptHigher.click();

		WebElement paymentClick = wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/payment_field")));

		paymentClick.click();

		driver.navigate().back();

		//////////////////////////////////
		/////// VERIFY SUCCESS MESSAGE////

		WebElement messageSuccess = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/info")));

		String actualMessage2 = messageSuccess.getText();

		System.out.println(actualMessage2);

		Assert.assertTrue(actualMessage2.contains("Uspešno ste uplatili"));

		////////////////////////////////////////////////////////
		/////// CLICK THE OK BUTTON/////////////////////////////

		WebElement clickOKButton = wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.mozzartbet.beta:id/action_success")));

		clickOKButton.click();

		////////////////////////////////////////////////////////
		////// BACK TO MAIN SCREEN AND TEARDOWN/////////////////

		driver.navigate().back();

		sleep(4);
	}

	public void sleep(long ms) {
		try {
			Thread.sleep(ms * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
