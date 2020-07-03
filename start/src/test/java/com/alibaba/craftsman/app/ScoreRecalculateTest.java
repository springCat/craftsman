package com.alibaba.craftsman.app;


import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.api.UserProfileServiceI;
import com.alibaba.craftsman.dto.ATAMetricAddCmd;
import com.alibaba.craftsman.dto.CodeReviewMetricAddCmd;
import com.alibaba.craftsman.dto.UserProfileAddCmd;
import com.alibaba.craftsman.dto.clientobject.UserProfileCO;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(ColaTestRunner.class)
//@ColaMockConfig(mocks={MetricTunnel.class, UserProfileTunnel.class})
public class ScoreRecalculateTest extends MockTestBase {
    private String userId;

    @Autowired
    private UserProfileServiceI userProfileServiceImpl;
    @Autowired
    private MetricsServiceI metricsServiceImpl;

    @Before
    public void init(){
        userId = "ScoreRecalculateTest" + System.currentTimeMillis();
    }

    //@Test
    public void testDevSuccess(){
        UserProfileAddCmd userProfileAddCmd = UserProfileCmdExeTest.prepareCommand(userId, UserProfileCO.DEV_ROLE);
        userProfileServiceImpl.addUserProfile(userProfileAddCmd);

        ATAMetricAddCmd ataMetricAddCmd = ATAMetricAddCmdExeTest.prepareCommand();
        metricsServiceImpl.addATAMetric(ataMetricAddCmd);
        metricsServiceImpl.addATAMetric(ataMetricAddCmd);
        metricsServiceImpl.addATAMetric(ataMetricAddCmd);
    }

    //@Test
    public void testQASuccess(){
        UserProfileAddCmd userProfileAddCmd = UserProfileCmdExeTest.prepareCommand(userId, UserProfileCO.QA_ROLE);
        userProfileServiceImpl.addUserProfile(userProfileAddCmd);

        CodeReviewMetricAddCmd codeReviewMetricAddCmd = CodeReviewMetricAddCmdExeTest.prepareCodeReviewMetricAddCmd(userId);
        metricsServiceImpl.addCodeReviewMetric(codeReviewMetricAddCmd);
        metricsServiceImpl.addCodeReviewMetric(codeReviewMetricAddCmd);
        metricsServiceImpl.addCodeReviewMetric(codeReviewMetricAddCmd);
    }
}
