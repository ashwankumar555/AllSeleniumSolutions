package listeners;

import annotations.TestCategory;
import io.qameta.allure.Allure;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class AllureCategoryListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();

        if (method.isAnnotationPresent(TestCategory.class)) {
            TestCategory category = method.getAnnotation(TestCategory.class);

            // ✅ Attach as Allure Tag (visible as filter in UI)
            Allure.label("tag", category.value());
        }
    }
}
