package com.kvb.lms.bbu.utils;

import com.microsoft.playwright.Page;

public class DriverFactory {
    private static Page page;

    public static void setPage(Page pageInstance) {
        page = pageInstance;
    }

    public static Page getPage() {
        return page;
    }

    public static void closePage() {
        if (page != null) {
            page.close();
        }
    }
}
