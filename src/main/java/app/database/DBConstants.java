package app.database;

public class DBConstants {

    // personal table
    public static final String PERSONAL_TABLE = "personal";
    public static final String PERSONAL_ID = "Id";
    public static final String PERSONAL_TYPE = "Type";
    public static final String PERSONAL_FIRSTNAME = "Firstname";
    public static final String PERSONAL_LASTNAME = "Lastname";
    public static final String PERSONAL_AGE = "Age";
    public static final String PERSONAL_PASSWORD = "Password";

    // client table
    public static final String CLIENT_TABLE = "clients";
    public static final String CLIENT_ID = "Id";
    public static final String CLIENT_FIRSTNAME = "Firstname";
    public static final String CLIENT_LASTNAME = "Lastname";
    public static final String CLIENT_AGE = "Age";
    public static final String CLIENT_PHONE = "Phone";
    public static final String CLIENT_PASSWORD = "Password";
    public static final String CLIENT_INVOICES = "InvoicesCount";
    public static final String CLIENT_CARDS = "CardsCount";
    public static final String CLIENT_CREDITS = "CreditsCount";

    // invoices table
    public static final String INVOICE_TABLE = "invoices";
    public static final String INVOICE_NUMBER = "Number";
    public static final String INVOICE_BALANCE = "Balance";
    public static final String INVOICE_CLIENT_ID = "ClientId";

    // cards table
    public static final String CARD_TABLE = "cards";
    public static final String CARD_NUMBER = "Number";
    public static final String CARD_INVOICE_NUMBER = "InvoiceNumber";
    public static final String CARD_BALANCE = "Balance";
    public static final String CARD_CLIENT_ID = "ClientId";

    // credits table
    public static final String CREDIT_TABLE = "credits";
    public static final String CREDIT_NUMBER = "Number";
    public static final String CREDIT_TYPE = "Type";
    public static final String CREDIT_SUM = "Sum";
    public static final String CREDIT_TIME = "Time";
    public static final String CREDIT_PERCENT = "Percent";
    public static final String CREDIT_PAYMENT = "Payment";
    public static final String CREDIT_CLIENT_ID = "ClientId";

    // requests table
    public static final String REQUEST_TABLE = "requests";
    public static final String REQUEST_NUMBER = "Number";
    public static final String REQUEST_TYPE = "Type";
    public static final String REQUEST_CLIENT_ID = "ClientId";
    public static final String REQUEST_CLIENT_FNAME = "ClientFirstname";
    public static final String REQUEST_CLIENT_LNAME = "ClientLastname";
    public static final String REQUEST_STATUS = "Status";

    // invoice requests table
    public static final String INVOICE_REQUEST_TABLE = "invoice_request";
    public static final String INVOICE_REQUEST_NUMBER = "Number";
    public static final String INVOICE_REQUEST_TYPE = "Type";
    public static final String INVOICE_REQUEST_INVNUMBER = "InvoiceNumber";
    public static final String INVOICE_REQUEST_CLIENT_ID = "ClientId";
    public static final String INVOICE_REQUEST_CLIENT_FIRSTNAME = "ClientFirstname";
    public static final String INVOICE_REQUEST_CLIENT_LASTNAME = "ClientLastname";
    public static final String INVOICE_REQUEST_STATUS = "Status";

    // card requests table
    public static final String CARD_REQUEST_TABLE = "card_request";
    public static final String CARD_REQUEST_NUMBER = "Number";
    public static final String CARD_REQUEST_TYPE = "Type";
    public static final String CARD_REQUEST_CRDNUMBER = "CardNumber";
    public static final String CARD_REQUEST_CLIENT_ID = "ClientId";
    public static final String CARD_REQUEST_CLIENT_FIRSTNAME = "ClientFirstname";
    public static final String CARD_REQUEST_CLIENT_LASTNAME = "ClientLastname";
    public static final String CARD_REQUEST_STATUS = "Status";

    // credit requests table
    public static final String CREDIT_REQUEST_TABLE = "credit_request";
    public static final String CREDIT_REQUEST_NUMBER = "Number";
    public static final String CREDIT_REQUEST_TYPE = "Type";
    public static final String CREDIT_REQUEST_SUM = "Sum";
    public static final String CREDIT_REQUEST_TIME = "Time";
    public static final String CREDIT_REQUEST_PERCENT = "Percent";
    public static final String CREDIT_REQUEST_PAYMENT = "Payment";
    public static final String CREDIT_REQUEST_CLIENT_ID = "ClientId";
    public static final String CREDIT_REQUEST_CLIENT_FIRSTNAME = "ClientFirstname";
    public static final String CREDIT_REQUEST_CLIENT_LASTNAME = "ClientLastname";
    public static final String CREDIT_REQUEST_STATUS = "Status";

    // client history table
    public static final String CLIENT_HISTORY_TABLE = "history_client_";
    public static final String CLIENT_HISTORY_NUMBER = "Number";
    public static final String CLIENT_HISTORY_ACTION = "Action";
    public static final String CLIENT_HISTORY_DATE = "Date";

    // personal history table
    public static final String PERSONAL_HISTORY_TABLE = "history_personal_";
    public static final String PERSONAL_HISTORY_NUMBER = "Number";
    public static final String PERSONAL_HISTORY_ID = "PersonalId";
    public static final String PERSONAL_HISTORY_ROLE = "PersonalRole";
    public static final String PERSONAL_HISTORY_ACTION = "Action";
    public static final String PERSONAL_HISTORY_DATE = "Date";
}
