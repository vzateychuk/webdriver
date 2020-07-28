package vez;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.StringUtils;
import vez.asud.config.Beans;
import vez.asud.login.HomePage;
import vez.asud.login.LoginAsUser;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final Map<String, String> userMap = Stream.of( new String[][]{
                {"SidorovSS", "Сидоров С. С."},
                {"Polyak.OV", "Поляк А. М."},
                {"PushkinaPP", "Пушкина П. П."},
                {"ErmakovEE", "Ермаков Е. Е."},
                {"IvanovIvanov", "Ivanov I. I."},
            }).collect(Collectors.toMap(s -> s[0], s -> s[1]));
    private static String user = System.getProperty("username");


    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        WebDriver driver = context.getBean("webDriverBean", WebDriver.class);
        WebDriverWait wait = context.getBean("webDriverWait", WebDriverWait.class);

        LocalTime startTime = LocalTime.now();
        System.out.println("Main.main. STARTED: "+ startTime);

        // open chrome with login
        LoginAsUser loginPage = new LoginAsUser(driver, wait);
        // login as
        String username = userMap.get(user);
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("User not found: " + user);
        }
        HomePage homePage = loginPage.loginValidUser(username);
        homePage.clickTreeItemTasks();

        LocalTime finishTime = LocalTime.now();
        System.out.println("Main.main. FINISH: at "+ finishTime);

        // closing the application context

/*
        driver.quit();
        context.close();
*/

        long sec = Duration.between(startTime, finishTime).getSeconds();
        System.out.println("Exec time(hh:mm:ss)="+ String.format("%d:%02d:%02d", sec/3600, (sec%3600)/60, (sec%60)));

        Assert.assertNotNull("Attempt to keep browser open", driver.findElement(By.name("OrgStructureViewer_branch_ddl_control_0")));

    }

}
