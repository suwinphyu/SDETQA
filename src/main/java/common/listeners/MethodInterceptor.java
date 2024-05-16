package common.listeners;

import common.constants.PathConfig;
import common.constants.TestCaseDetails;
import common.utils.CSVReader;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    List<IMethodInstance> testCaseList = new ArrayList<>();


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            mapList.addAll(CSVReader.read(new File(PathConfig.TEST_SCENARIOS)));
            testCaseList = getTestCaseListToRun(methods, mapList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testCaseList;
    }

    private List<IMethodInstance> getTestCaseListToRun(List<IMethodInstance> methodInstanceList, List<Map<String, String>> mapList) {
        for (IMethodInstance methodInstance : methodInstanceList) {
            for (Map<String, String> map : mapList) {
                if (methodInstance.getMethod().getMethodName().equalsIgnoreCase(map.get(TestCaseDetails.NAME.toString().toLowerCase())) &&
                        map.get(TestCaseDetails.EXECUTE.toString().toLowerCase()).equalsIgnoreCase("true")) {

                    methodInstance.getMethod().setDescription(map.get(TestCaseDetails.DESCRIPTION.toString().toLowerCase()));
                    testCaseList.add(methodInstance);
                }
            }
        }
        return testCaseList;
    }
}
