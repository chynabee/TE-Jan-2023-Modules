package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test

    public void testPartialString() {

        String a = "Hello";
        String b = "There";

        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString(a, b);

        Assert.assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
    }

    @Test

    public void testPartialString1() {

        String a = "java";
        String b = "code";

        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString("java", "code");

        Assert.assertEquals("avaode", result);
    }

    @Test

    public void testPartialString2() {

        String a = "Chyna";
        String b = "Broyles";

        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString("Chyna", "Broyles");

        Assert.assertEquals("hynaroyles", result);
    }

    @Test

    public void testPartialStringNull() {


        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString(null, null);

        Assert.assertEquals("", result);

    }
    @Test
    public void testPartialString3() {



        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString("", "java");

        Assert.assertEquals("ava", result);

    }

    @Test
    public void testPartialString4() {

        NonStart nonStart = new NonStart();

        String result = nonStart.getPartialString("java", "" );

        Assert.assertEquals("ava", result);
    }




}


