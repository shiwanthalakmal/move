package com.vendesilk.ui.element.behavior;

import com.vendesilk.ui.exception.ApplicationException;
import com.vendesilk.ui.exception.ScriptException;

public interface Element {
    public String getText() throws ApplicationException, ScriptException;

    public boolean isDisplayed() throws ApplicationException;

    public boolean isEnabled() throws ApplicationException, ScriptException;

    public boolean isDisabled() throws ApplicationException, ScriptException;

    public boolean isSelected() throws ApplicationException, ScriptException;

    public void mouseMove();

    public boolean verifyElementMemorizedTextIs(String memoryKey) throws ApplicationException, ScriptException;

    public boolean verifyElementMemorizedTextIsIgnoreCase(String memoryKey) throws ApplicationException, ScriptException;

    public boolean verifyElementContainsMemorizedText(String memoryKey) throws ApplicationException, ScriptException;

    public boolean verifyElementTextIs(String text) throws ApplicationException, ScriptException;

    public boolean verifyElementTextIsIgnoreCase(String text) throws ApplicationException, ScriptException;

    public boolean verifyElementTextContains(String text) throws ApplicationException, ScriptException;

    boolean verifyElementExists() throws ApplicationException;

    public boolean isNotDisplayed() throws ApplicationException;

    public void waitTillElementVisible(Integer maxWaitTime);

    public String getEvaluatedValue();

    public void setEvaluatedValue(String value);
}
