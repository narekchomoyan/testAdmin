package main.com.Server;

/**
 * Created by narek on 3/10/17.
 */
public class NetworkConstants {
//        public static final String SERVER_URL = "http://54.202.229.250:8080/";
//        public static final String SERVER_URL = "http://localhost:8085";
        public static final String SERVER_URL = "http://127.0.0.1:8080/";
        public static final String SERVER_PREFIX = "bank-1.4-SNAPSHOT";
//        public static final String SERVER_PREFIX = "";

        public static final String INNER_PREFIX = "/bank-2.1/";
//        public static final String INNER_PREFIX = "";
//        public static final String MY_SERVER_URL = "http://localhost:8082/";
        public static final String MY_SERVER_URL = "http://54.202.229.250:8080";


        /** API **/
        public static final String LOGIN_URL = SERVER_URL + SERVER_PREFIX +"/api/user/login";
        public static final String LOG_OUT_URL = SERVER_URL + SERVER_PREFIX +"/api/user/logOut";
        public static final String DEBT_URL = SERVER_URL + SERVER_PREFIX +"/api/payments/debt";
        public static final String PAYMENT_URL =SERVER_URL + SERVER_PREFIX +"/api/payments/payment";
        public static final String POLLING_URL = SERVER_URL + SERVER_PREFIX + "/api/poling";
        public static final String CHANGE_CURRENT_CLIENT_URL = SERVER_URL + SERVER_PREFIX + "/ChangeCurrentClient";

        /** Messageing **/
        public static final String GET_MY_CONVERSATIONS_URL = SERVER_URL + SERVER_PREFIX + "/GetMyConversations";
        public static final String GET_MESSAGES_BY_CONVERSATION_ID_URL = SERVER_URL + SERVER_PREFIX + "/GetMessagesByConversationId";
        public static final String START_CONVERSATION_URL = SERVER_URL + SERVER_PREFIX + "/StartConversation";
        public static final String SEND_MESSAGE_URL = SERVER_URL + SERVER_PREFIX + "/SendMessage";
        /**getDataApis-s **/
        public static final String GET_ACCOUNTS_URL = SERVER_URL + SERVER_PREFIX + "/GetAccounts";
        public static final String GET_CARDS_URL = SERVER_URL + SERVER_PREFIX + "/GetCards";
        public static final String GET_DEPOSITS_URL = SERVER_URL + SERVER_PREFIX + "/GetDeposits";
        public static final String GET_LOANS_URL = SERVER_URL + SERVER_PREFIX + "/GetLoans";
        /**getDataReports**/
        public static final String GET_CARD_REPORT_URL = SERVER_URL + SERVER_PREFIX + "/GetCardReport";
        public static final String GET_DEPOSIT_REPORT_URL = SERVER_URL + SERVER_PREFIX + "/GetDepositReport";
        public static final String GET_LOAN_REPORT_URL = SERVER_URL + SERVER_PREFIX + "/GetLoanReport";
        public static final String GET_ACCOUNT_REPORT_URL = SERVER_URL + SERVER_PREFIX + "/GetAccountReport";
        public static final String GET_REPORTS_FILE_REQUEST = SERVER_URL + SERVER_PREFIX + "/GetReportsFile";
        /**Rates**/
        public static final String Get_RATES_URL = SERVER_URL + SERVER_PREFIX + "/Rates";
        public static final String Get_CROSS_RATES_URL = SERVER_URL + SERVER_PREFIX + "/CrossRates";
        /** Transfers**/
        public static final String GET_AVIALABLE_ACCOUNTS_URL = SERVER_URL + SERVER_PREFIX +"/GetAvailableAccounts";
        public static final String SAVE_TRANSFER_URL = SERVER_URL + SERVER_PREFIX +"/SaveTransfer";
        public static final String DELETE_TRANSFER_URL = SERVER_URL + SERVER_PREFIX +"/DeleteTransfer";
        public static final String SEND_TRANSFER_URL = SERVER_URL + SERVER_PREFIX +"/SendTransfer";
        public static final String UPDATE_TRANSFER_URL = SERVER_URL + SERVER_PREFIX +"/UpdateTransferDataEvent";
        public static final String GET_TRANSFERS_URL = SERVER_URL + SERVER_PREFIX +"/GetTransfers";
        public static final String GET_TRANSFERS_FOR_ID_URL = SERVER_URL + SERVER_PREFIX +"/GetTransferForId";
        public static final String GET_DOCUMENT_NUMBER_FOR_USER_URL = SERVER_URL + SERVER_PREFIX +"/GetDocumentNumberForUser";
        /**Requests**/
        public static final String GET_EMBASIES_URL = SERVER_URL + SERVER_PREFIX +"/Embassies";
        public static final String GET_BRACCHES_URL = SERVER_URL + SERVER_PREFIX +"/Branches";
        /** Contacts **/
        public static final String CREATE_CONTACT_URL = SERVER_URL + SERVER_PREFIX +"/CreateContact";
        public static final String GET_CONTACTS_URL = SERVER_URL + SERVER_PREFIX +"/GetContactList";
        /** LOAN **/
        public static final String GET_LOAN_CHART_URL = SERVER_URL + SERVER_PREFIX +"/GetLoanChart";
        /** DATA **/
        public static final String GET_ACCOUNT_URL = SERVER_URL + SERVER_PREFIX +"/GetAccount";
        public static final String GET_DEPOSIT_URL = SERVER_URL + SERVER_PREFIX +"/GetDeposit";
        public static final String GET_LOAN_URL = SERVER_URL + SERVER_PREFIX +"/GetLoan";
        public static final String GET_CARD_URL = SERVER_URL + SERVER_PREFIX +"/GetCard";
        /**Card management **/
        public static final String MANAGE_CARD_URL = SERVER_URL + SERVER_PREFIX +"/ManageCard";
        public static final String GET_CARD_BALANCE_URL = SERVER_URL + SERVER_PREFIX +"/GetCardBalance";

        /** Requests **/
        public static final String SAVE_REQUEST_FORM_URL = SERVER_URL + SERVER_PREFIX + "/SaveRequest";

        /**ComunalSearch**/
        public static final String COMUNAL_SEARCH_URL = SERVER_URL+ SERVER_PREFIX + "/SearchCommunal";
        /**Map **/
        public static final String GET_MAP_DATA_URL = SERVER_URL+ SERVER_PREFIX + "/GetMapLocations";
        /**Helpers**/
        public static final String GET_TRANSFER_DATA_URL = SERVER_URL+ SERVER_PREFIX + "/GetTransferServiceData";

}
