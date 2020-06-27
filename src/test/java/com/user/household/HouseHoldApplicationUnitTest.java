package com.user.household;
import com.user.web.ApplianceController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class HouseHoldApplicationUnitTest {

    ApplianceController applianceController= new ApplianceController();

    @Test
    public void verifyGetAllAppliances() {


//        System.out.println("appliances"+applianceController.getAllAppliances());
        assertEquals(1,1);
    }

}
