import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupplierPage_auto {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> britishGas1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> britishGas2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> britishGas3;

    private final String britishGasValue = "39";

    private final String britishGasValue = "39";

    private final String britishGasValue = "39";

    @FindBy(id = "change-postcode")
    @CacheLookup
    private WebElement changePostcode;

    @FindBy(id = "ctm-logo")
    @CacheLookup
    private WebElement comparethemarketCom;

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> eOn1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> eOn2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> eOn3;

    private final String eOnValue = "59";

    private final String eOnValue = "59";

    private final String eOnValue = "59";

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> edfEnergy1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> edfEnergy2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> edfEnergy3;

    private final String edfEnergyValue = "83";

    private final String edfEnergyValue = "83";

    private final String edfEnergyValue = "83";

    @FindBy(name = "compare-what-energy")
    @CacheLookup
    private List<WebElement> electricityOnly;

    private final String electricityOnlyValue = "Electricity";

    @FindBy(id = "find-postcode")
    @CacheLookup
    private WebElement findPostcode;

    @FindBy(name = "compare-what-energy")
    @CacheLookup
    private List<WebElement> gasElectricity;

    private final String gasElectricityValue = "both";

    @FindBy(name = "compare-what-energy")
    @CacheLookup
    private List<WebElement> gasOnly;

    private final String gasOnlyValue = "Gas";

    @FindBy(name = "bill-nobill")
    @CacheLookup
    private List<WebElement> iDontHaveMyBill;

    private final String iDontHaveMyBillValue = "DontHaveMyBill";

    @FindBy(id = "electricity-supplier-dont-know")
    @CacheLookup
    private WebElement iDontKnow1;

    @FindBy(id = "gas-supplier-dont-know")
    @CacheLookup
    private WebElement iDontKnow2;

    @FindBy(name = "bill-nobill")
    @CacheLookup
    private List<WebElement> iveGotMyBill;

    private final String iveGotMyBillValue = "HaveMyBill";

    @FindBy(id = "goto-your-supplier-details")
    @CacheLookup
    private WebElement next;

    @FindBy(name = "same-supplier")
    @CacheLookup
    private List<WebElement> no;

    private final String noValue = "false";

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> npower1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> npower2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> npower3;

    private final String npowerValue = "57";

    private final String npowerValue = "57";

    private final String npowerValue = "57";

    @FindBy(id = "sel")
    @CacheLookup
    private WebElement otherSupplier1;

    @FindBy(css = "#sel_chosen a.chosen-single")
    @CacheLookup
    private WebElement otherSupplier2;

    @FindBy(id = "sel1")
    @CacheLookup
    private WebElement otherSupplier3;

    @FindBy(css = "#sel1_chosen a.chosen-single")
    @CacheLookup
    private WebElement otherSupplier4;

    @FindBy(id = "sel2")
    @CacheLookup
    private WebElement otherSupplier5;

    @FindBy(css = "#sel2_chosen a.chosen-single")
    @CacheLookup
    private WebElement otherSupplier6;

    private final String pageLoadedText = "We may use your data for marketing and you will be given an opportunity to decide whether you wish to receive marketing from us";

    private final String pageUrl = "/energy/v2/";

    @FindBy(css = "a[href='http://www.comparethemarket.com/information/privacy-policy/']")
    @CacheLookup
    private WebElement privacyCookiePolicy;

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> scottishPower1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> scottishPower2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> scottishPower3;

    private final String scottishPowerValue = "61";

    private final String scottishPowerValue = "61";

    private final String scottishPowerValue = "61";

    @FindBy(name = "dual-top-six")
    @CacheLookup
    private List<WebElement> sse1;

    @FindBy(name = "electricity-top-six")
    @CacheLookup
    private List<WebElement> sse2;

    @FindBy(name = "gas-top-six")
    @CacheLookup
    private List<WebElement> sse3;

    private final String sseValue = "101";

    private final String sseValue = "101";

    private final String sseValue = "101";

    @FindBy(css = "a[href='http://www.comparethemarket.com/information/terms-and-conditions/']")
    @CacheLookup
    private WebElement termsAndConditions;

    @FindBy(css = "a.arrow-before")
    @CacheLookup
    private WebElement viewQuestion;

    @FindBy(id = "your-postcode")
    @CacheLookup
    private WebElement whatIsYourPostcode;

    @FindBy(name = "same-supplier")
    @CacheLookup
    private List<WebElement> yes;

    private final String yesValue = "true";

    public SupplierPage_auto() {
    }

    public SupplierPage_auto(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public SupplierPage_auto(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public SupplierPage_auto(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Change Postcode Button.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickChangePostcodeButton() {
        changePostcode.click();
        return this;
    }

    /**
     * Click on Comparethemarket.com Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickComparethemarketComLink() {
        comparethemarketCom.click();
        return this;
    }

    /**
     * Click on Find Postcode Button.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickFindPostcodeButton() {
        findPostcode.click();
        return this;
    }

    /**
     * Click on Next Button.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickNextButton() {
        next.click();
        return this;
    }

    /**
     * Set default value to Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickOtherSupplier1Link() {
        return clickOtherSupplier1Link(data.get("OTHER_SUPPLIER"));
    }

    /**
     * Click on Other Supplier Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickOtherSupplier1Link(String otherSupplierValue) {
        new Select(otherSupplier1).selectByVisibleText(otherSupplierValue);
        return this;
    }

    /**
     * Click on Other Supplier Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickOtherSupplier2Link() {
        otherSupplier2.click();
        return this;
    }

    /**
     * Click on Other Supplier Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickOtherSupplier4Link() {
        otherSupplier4.click();
        return this;
    }

    /**
     * Click on Other Supplier Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickOtherSupplier6Link() {
        otherSupplier6.click();
        return this;
    }

    /**
     * Click on Privacy Cookie Policy Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickPrivacyCookiePolicyLink() {
        privacyCookiePolicy.click();
        return this;
    }

    /**
     * Click on Terms And Conditions Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickTermsAndConditionsLink() {
        termsAndConditions.click();
        return this;
    }

    /**
     * Click on View Question Link.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto clickViewQuestionLink() {
        viewQuestion.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto fill() {
        setWhatIsYourPostcodeTextField();
        setIveGotMyBillRadioButtonField();
        setIDontHaveMyBillRadioButtonField();
        setGasElectricityRadioButtonField();
        setElectricityOnlyRadioButtonField();
        setGasOnlyRadioButtonField();
        setYesRadioButtonField();
        setNoRadioButtonField();
        setBritishGas1RadioButtonField();
        setEdfEnergy1RadioButtonField();
        setEOn1RadioButtonField();
        setNpower1RadioButtonField();
        setScottishPower1RadioButtonField();
        setSse1RadioButtonField();
        clickOtherSupplier1Link();
        setBritishGas2RadioButtonField();
        setEdfEnergy2RadioButtonField();
        setEOn2RadioButtonField();
        setNpower2RadioButtonField();
        setScottishPower2RadioButtonField();
        setSse2RadioButtonField();
        setOtherSupplier3DropDownListField();
        setIDontKnow1CheckboxField();
        setBritishGas3RadioButtonField();
        setEdfEnergy3RadioButtonField();
        setEOn3RadioButtonField();
        setNpower3RadioButtonField();
        setScottishPower3RadioButtonField();
        setSse3RadioButtonField();
        setOtherSupplier5DropDownListField();
        setIDontKnow2CheckboxField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to British Gas Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setBritishGas1RadioButtonField() {
        for (WebElement el : britishGas1) {
            if (el.getAttribute("value").equals(britishGas1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to British Gas Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setBritishGas2RadioButtonField() {
        for (WebElement el : britishGas2) {
            if (el.getAttribute("value").equals(britishGas2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to British Gas Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setBritishGas3RadioButtonField() {
        for (WebElement el : britishGas3) {
            if (el.getAttribute("value").equals(britishGas3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to E.on Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEOn1RadioButtonField() {
        for (WebElement el : eOn1) {
            if (el.getAttribute("value").equals(eOn1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to E.on Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEOn2RadioButtonField() {
        for (WebElement el : eOn2) {
            if (el.getAttribute("value").equals(eOn2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to E.on Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEOn3RadioButtonField() {
        for (WebElement el : eOn3) {
            if (el.getAttribute("value").equals(eOn3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Edf Energy Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEdfEnergy1RadioButtonField() {
        for (WebElement el : edfEnergy1) {
            if (el.getAttribute("value").equals(edfEnergy1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Edf Energy Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEdfEnergy2RadioButtonField() {
        for (WebElement el : edfEnergy2) {
            if (el.getAttribute("value").equals(edfEnergy2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Edf Energy Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setEdfEnergy3RadioButtonField() {
        for (WebElement el : edfEnergy3) {
            if (el.getAttribute("value").equals(edfEnergy3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Electricity Only Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setElectricityOnlyRadioButtonField() {
        for (WebElement el : electricityOnly) {
            if (el.getAttribute("value").equals(electricityOnlyValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Gas Electricity Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setGasElectricityRadioButtonField() {
        for (WebElement el : gasElectricity) {
            if (el.getAttribute("value").equals(gasElectricityValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Gas Only Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setGasOnlyRadioButtonField() {
        for (WebElement el : gasOnly) {
            if (el.getAttribute("value").equals(gasOnlyValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to I Dont Have My Bill Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setIDontHaveMyBillRadioButtonField() {
        for (WebElement el : iDontHaveMyBill) {
            if (el.getAttribute("value").equals(iDontHaveMyBillValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set I Dont Know Checkbox field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setIDontKnow1CheckboxField() {
        if (!iDontKnow1.isSelected()) {
            iDontKnow1.click();
        }
        return this;
    }

    /**
     * Set I Dont Know Checkbox field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setIDontKnow2CheckboxField() {
        if (!iDontKnow2.isSelected()) {
            iDontKnow2.click();
        }
        return this;
    }

    /**
     * Set default value to Ive Got My Bill Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setIveGotMyBillRadioButtonField() {
        for (WebElement el : iveGotMyBill) {
            if (el.getAttribute("value").equals(iveGotMyBillValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to No Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setNoRadioButtonField() {
        for (WebElement el : no) {
            if (el.getAttribute("value").equals(noValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Npower Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setNpower1RadioButtonField() {
        for (WebElement el : npower1) {
            if (el.getAttribute("value").equals(npower1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Npower Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setNpower2RadioButtonField() {
        for (WebElement el : npower2) {
            if (el.getAttribute("value").equals(npower2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Npower Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setNpower3RadioButtonField() {
        for (WebElement el : npower3) {
            if (el.getAttribute("value").equals(npower3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setOtherSupplier3DropDownListField() {
        return setOtherSupplier3DropDownListField(data.get("OTHER_SUPPLIER_3"));
    }

    /**
     * Set value to Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setOtherSupplier3DropDownListField(String otherSupplier3Value) {
        new Select(otherSupplier3).selectByVisibleText(otherSupplier3Value);
        return this;
    }

    /**
     * Set default value to Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setOtherSupplier5DropDownListField() {
        return setOtherSupplier5DropDownListField(data.get("OTHER_SUPPLIER_5"));
    }

    /**
     * Set value to Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setOtherSupplier5DropDownListField(String otherSupplier5Value) {
        new Select(otherSupplier5).selectByVisibleText(otherSupplier5Value);
        return this;
    }

    /**
     * Set default value to Scottish Power Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setScottishPower1RadioButtonField() {
        for (WebElement el : scottishPower1) {
            if (el.getAttribute("value").equals(scottishPower1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Scottish Power Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setScottishPower2RadioButtonField() {
        for (WebElement el : scottishPower2) {
            if (el.getAttribute("value").equals(scottishPower2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Scottish Power Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setScottishPower3RadioButtonField() {
        for (WebElement el : scottishPower3) {
            if (el.getAttribute("value").equals(scottishPower3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Sse Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setSse1RadioButtonField() {
        for (WebElement el : sse1) {
            if (el.getAttribute("value").equals(sse1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Sse Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setSse2RadioButtonField() {
        for (WebElement el : sse2) {
            if (el.getAttribute("value").equals(sse2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Sse Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setSse3RadioButtonField() {
        for (WebElement el : sse3) {
            if (el.getAttribute("value").equals(sse3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to What Is Your Postcode Text field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setWhatIsYourPostcodeTextField() {
        return setWhatIsYourPostcodeTextField(data.get("WHAT_IS_YOUR_POSTCODE"));
    }

    /**
     * Set value to What Is Your Postcode Text field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setWhatIsYourPostcodeTextField(String whatIsYourPostcodeValue) {
        whatIsYourPostcode.sendKeys(whatIsYourPostcodeValue);
        return this;
    }

    /**
     * Set default value to Yes Radio Button field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto setYesRadioButtonField() {
        for (WebElement el : yes) {
            if (el.getAttribute("value").equals(yesValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto submit() {
        clickFindPostcodeButton();
        return this;
    }

    /**
     * Unset I Dont Know Checkbox field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetIDontKnow1CheckboxField() {
        if (iDontKnow1.isSelected()) {
            iDontKnow1.click();
        }
        return this;
    }

    /**
     * Unset I Dont Know Checkbox field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetIDontKnow2CheckboxField() {
        if (iDontKnow2.isSelected()) {
            iDontKnow2.click();
        }
        return this;
    }

    /**
     * Unset default value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplier3DropDownListField() {
        return unsetOtherSupplier3DropDownListField(data.get("OTHER_SUPPLIER_3"));
    }

    /**
     * Unset value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplier3DropDownListField(String otherSupplier3Value) {
        new Select(otherSupplier3).deselectByVisibleText(otherSupplier3Value);
        return this;
    }

    /**
     * Unset default value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplier5DropDownListField() {
        return unsetOtherSupplier5DropDownListField(data.get("OTHER_SUPPLIER_5"));
    }

    /**
     * Unset value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplier5DropDownListField(String otherSupplier5Value) {
        new Select(otherSupplier5).deselectByVisibleText(otherSupplier5Value);
        return this;
    }

    /**
     * Unset default value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplierDropDownListField() {
        return unsetOtherSupplierDropDownListField(data.get("OTHER_SUPPLIER"));
    }

    /**
     * Unset value from Other Supplier Drop Down List field.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto unsetOtherSupplierDropDownListField(String otherSupplierValue) {
        new Select(otherSupplier).deselectByVisibleText(otherSupplierValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the SupplierPage_auto class instance.
     */
    public SupplierPage_auto verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
