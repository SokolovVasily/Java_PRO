package org.example.hw19_08_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HomeWorkTest {
    private String path = "C:\\Users\\sokol\\IdeaProjects\\Less1\\src\\main\\java\\org\\example\\hw19_08_11\\1.txt";
    //private List<String> stringListLines = HomeWork.returnListFromFile(path);
    private List<String> stringListLines = Arrays.asList(       //делаем короткий свой лист
            "+1-240-701-5763x6875 - Jose Edwards",
            "(432)461-5121 - Lisa Herman",
            "+1-159-322-4388x60509 - Timothy Mitchell",
            "8853301072 - Courtney Griffin MD",
            "(885)624-5862x792 - Jose Mitchell"     // сделаем одинак имя фамил у двоих персоонаж для ТЕСТОВ))
    );
    private List<String> listName = HomeWork.returnListName(stringListLines);
    private final Map<Character, Long> characterLongMap = HomeWork.createMapKeyFirstLetterNameValueCount(listName);

    private List<String> listStringPhoneNumber = HomeWork.returnListPhoneNumber(stringListLines);


    //---------------------------------------------------1 returnListFromFile -----------------------------------------
    //1.0 тпротестировать методы которые парсят файл 1.txt и...

    //Posit list != null
    //throw new IllegalArgumentException(): String path == null
    //throw new RuntimeException(e): String path = "iztizrlur"

    @Test
    public void returnListFromFilePositiveReturnNotNullTest() {
        Assertions.assertNotNull(HomeWork.returnListFromFile(path));
    }

    @Test
    public void returnListFromFileIllegalArgumentExceptionPathIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> HomeWork.returnListFromFile(null));
    }

    @Test
    public void returnListFromFileRuntimeExceptionPathFileNotFoundTest() {
        path = "kjhgj";
        Assertions.assertThrows(RuntimeException.class, () -> HomeWork.returnListFromFile(path));
    }
    //---------------------------------------------------1.1 returnListName -----------------------------------------
    //public static List<String> returnListName(List<String>stringListLines) {

    //Posit nameList != null
    @Test
    public void returnListNamePositiveReturnNotNullTest() {
        Assertions.assertNotNull(HomeWork.returnListName(stringListLines));
    }

    //Posit nameList.size()
    @Test
    public void returnListNamePositiveNameListSizeTest() {
        assertEquals(5, HomeWork.returnListName(stringListLines).size());
    }

    //Posit nameList.get()        инфа по индексу -> проверка
    @Test
    public void returnListNamePositiveNameListGetTest() {
        assertEquals("Jose", HomeWork.returnListName(stringListLines).get(0));
        assertEquals("Timothy", HomeWork.returnListName(stringListLines).get(2));
    }

    //if (stringListLines == null IllegalArgumentException
    @Test
    public void returnListNameIllegalArgumentExceptionListEqualsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> HomeWork.returnListName(null));
    }

    //stringListLines.isEmpty()) IllegalArgumentException
    @Test
    public void returnListNameIllegalArgumentExceptionListIsEmptyTest() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> HomeWork.returnListName(stringListLines));
    }
    //---------------------------------------------------1.2 returnListPhoneNumber -----------------------------------------

    //public static List<String> returnListPhoneNumber(List<String>stringListLines) {
    //Posit phoneList != null
    @Test
    public void returnListPhoneNumberPositiveReturnNotNullTest() {
        Assertions.assertNotNull(HomeWork.returnListPhoneNumber(stringListLines));
    }

    //Posit phoneList.size()
    @Test
    public void returnListPhoneNumberPositivePhoneListSizeTest() {
        assertEquals(5, HomeWork.returnListPhoneNumber(stringListLines).size());
    }

    //Posit phoneList.get()        инфа по индексу -> проверка
    @Test
    public void returnListPhoneNumberPositivePhoneListGetTest() {
        assertEquals("124070157636875", HomeWork.returnListPhoneNumber(stringListLines).get(0));
        assertEquals("8856245862792", HomeWork.returnListPhoneNumber(stringListLines).get(4));
    }

    //if (stringListLines == null IllegalArgumentException
    @Test
    public void returnListPhoneNumberIllegalArgumentExceptionListEqualsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> HomeWork.returnListPhoneNumber(null));
    }

    //stringListLines.isEmpty()) IllegalArgumentException
    @Test
    public void returnListPhoneNumberIllegalArgumentExceptionListIsEmptyTest() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> HomeWork.returnListPhoneNumber(stringListLines));
    }

    //--------------------------------2. createMapKeyFirstLetterNameValueCount ----------------------------------------
    // Positive Test Map != null
    @Test
    public void createMapKeyFirstLetterNameValueCountPositiveReturnMapNotNullTest() {
        Assertions.assertNotNull(HomeWork.createMapKeyFirstLetterNameValueCount(listName));
    }

    // Positive Test Map.size //размер=ожид разм
    @Test
    public void createMapKeyFirstLetterNameValueCountPositiveMapSizeTest() {
        assertEquals(4, HomeWork.createMapKeyFirstLetterNameValueCount(listName).size());
    }

    // Positive Test Map.get(Key)// проверка на правильность формирования ключей и значений
    @Test
    public void createMapKeyFirstLetterNameValueCountPositiveMapGetKeyTest() {
        assertEquals(2, HomeWork.createMapKeyFirstLetterNameValueCount(listName).get('J'));
    }

    //  if (listName == null IllegalArgumentException
    @Test
    public void createMapKeyFirstLetterNameValueCountIllegalArgumentExceptionIfListNameNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createMapKeyFirstLetterNameValueCount(null));
    }

    // if (listName.isEmpty()) IllegalArgumentException
    @Test
    public void createMapKeyFirstLetterNameValueCountIllegalArgumentExceptionIfListIsEmptyTest() {
        listName = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createMapKeyFirstLetterNameValueCount(listName));
    }

    //--------------------------3 .returnMostPopularLetterName ----------------------------------------------------
    //public static String returnMostPopularLetterName(Map<Character, Long> characterLongMap) {// Most -viel
    // Positive return not null
    @Test
    public void returnMostPopularLetterNamePositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.returnMostPopularLetterName(characterLongMap));
    }

    //Positive returnLetter
    @Test
    public void returnMostPopularLetterNamePositiveTest() {
        assertEquals("J", HomeWork.returnMostPopularLetterName(characterLongMap));//на возврат String
    }

    //if (characterLongMap == null) {
    @Test
    public void returnMostPopularLetterNameIllegalArgumentExceptionMapIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.returnMostPopularLetterName(null));
    }

    //----------------------------4 createLongListPhoneNumber.-------------------------------------------------------------------------
    //public static List<Long> createLongListPhoneNumber(List<String> listStringPhoneNumber) {
    //Positive return not null
    @Test
    public void createLongListPhoneNumberPositiveReturnNotNullTest() {
        Assertions.assertNotNull(HomeWork.createLongListPhoneNumber(listStringPhoneNumber));
    }

    //Positive list.size()
    @Test
    public void createLongListPhoneNumberPositiveListSizeTest() {
        assertEquals(5, HomeWork.createLongListPhoneNumber(listStringPhoneNumber).size());
    }

    //Positive list.get()
    @Test
    public void createLongListPhoneNumberPositiveListGetTest() { //при срав-ии 1-му елем.делаем -("") и +(L) и делаем Лонг из Стринг
        assertEquals(4324615121L, HomeWork.createLongListPhoneNumber(listStringPhoneNumber).get(1));
    }

    //if (listStringPhoneNumber == null){
    @Test
    public void createLongListPhoneNumberIllegalArgumentExceptionListIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createLongListPhoneNumber(null));
    }

    //if(listStringPhoneNumber.isEmpty()) IllegalArgumentException
    @Test
    public void createLongListPhoneNumberIllegalArgumentExceptionListIsEmptyTest() {
        listStringPhoneNumber = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createLongListPhoneNumber(listStringPhoneNumber));
    }

    //------------------------------5.sortNameByLength ---------------------------------------------------------------------------
// public static List<String> sortNameByLength(List<String> nameList) {

    //Positive sortedNameList !=null;
    //Positive sortedNameList.size();
    //Positive sortedNameList.get
    //if (nameList == null
    //nameList.isEmpty())
    @Test
    public void sortNameByLengthPositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.sortNameByLength(listName));
    }

    @Test
    public void sortNameByLengthPositiveListSizeTest() {
        Assertions.assertEquals(5, HomeWork.sortNameByLength(listName).size());
    }

    @Test
    public void sortNameByLengthPositiveListGetTest() {
        Assertions.assertEquals("Jose", HomeWork.sortNameByLength(listName).get(2));//спросить про порядок
    }

    @Test
    public void sortNameByLengthIllegalArgumentExceptionListIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.sortNameByLength(null));
    }

    @Test
    public void sortNameByLengthIllegalArgumentExceptionListIsEmptyTest() {
        listName = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.sortNameByLength(listName));
    }
//-------------------------------6.returnSetUniqueLastName            ------------------------------------------------------------------------
//public static Set<String> returnListUniqueLastName(List<String> stringListLines) {
    //Posit lastNameList != null
    //Posit lastNameList.size()
    //Posit lastNameList.get()
    //if (stringListLines == null IllegalArgumentException
    // stringListLines.isEmpty()) IllegalArgumentException

    @Test
    public void returnSetUniqueLastNamePositiveReturnNotNullTest() {
        Assertions.assertNotNull(HomeWork.returnSetUniqueLastName(stringListLines));
    }

    @Test
    public void returnSetUniqueLastNamePositiveNameListSizeTest() {
        assertEquals(4, HomeWork.returnSetUniqueLastName(stringListLines).size()); //один сложился
    }

    @Test
    public void returnSetUniqueLastNamePositiveNameSetContainsElTest() {
        assertTrue(HomeWork.returnSetUniqueLastName(stringListLines).contains((Object) "Edwards"));
        assertTrue(HomeWork.returnSetUniqueLastName(stringListLines).contains((Object) "Mitchell"));

    }

/*

 ожидаю true  Homework.method().contains((Object)фамилия) -

 */


    @Test
    public void returnSetUniqueLastNameIllegalArgumentExceptionListEqualsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.returnSetUniqueLastName(null));
    }

    @Test
    public void returnSetUniqueLastNameIllegalArgumentExceptionListIsEmptyTest() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.returnSetUniqueLastName(stringListLines));
    }


    //--------------------------------7.createListNameReverseOrder ----------------------------------------------------------------------
//public static List<String> createListNameReverseOrder(List<String> listName) {
    //-Метод для преобразования данных в формат имя=номер
    //Positive not Null;
    //Positive list.size
    //Positive list.get
    // if (listName == null)
    //listName.isEmpty())
    @Test
    public void createListNameReverseOrderPositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.createListNameReverseOrder(listName));
    }

    @Test
    public void createListNameReverseOrderPositiveListSizeTest() {
        Assertions.assertEquals(5, HomeWork.createListNameReverseOrder(listName).size());
    }

    @Test
    public void createListNameReverseOrderPositiveListGetTest() {
        Assertions.assertEquals("Jose", HomeWork.createListNameReverseOrder(listName).get(2));//спросить про порядок
    }

    @Test
    public void createListNameReverseOrderIllegalArgumentExceptionListIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createListNameReverseOrder(null));
    }

    @Test
    public void createListNameReverseOrderIllegalArgumentExceptionListIsEmptyTest() {
        listName = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createListNameReverseOrder(listName));
    }
//------------------8.transformationDataInNameAndNumberFormat-----------------------------------------------------------
//public static List<String> transformationDataInNameAndNumberFormat(List<String> stringListLines) {
    //Positive test nameNumberList != null
    //Positive nameNumberList.size();
    //Positive nameNumberList.get()
    //stringListLines.isEmpty()){
    //if (stringListLines == null

    @Test
    public void transformationDataInNameAndNumberFormatPositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.transformationDataInNameAndNumberFormat(stringListLines));
    }

    @Test
    public void transformationDataInNameAndNumberFormatPositiveListSizeTest() {
        Assertions.assertEquals(5,
                HomeWork.transformationDataInNameAndNumberFormat(stringListLines).size());
    }

    @Test
    public void transformationDataInNameAndNumberFormatPositiveListGetTest() {
        Assertions.assertEquals("Jose=124070157636875",
                HomeWork.transformationDataInNameAndNumberFormat(stringListLines).get(0));
    }

    @Test
    public void transformationDataInNameAndNumberFormatIllegalArgumentExceptionListIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.transformationDataInNameAndNumberFormat(null));
    }

    @Test
    public void transformationDataInNameAndNumberFormatIllegalArgumentExceptionListIsEmptyTest() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.transformationDataInNameAndNumberFormat(stringListLines));
    }
//-----------------------9.returnAverageLengthNames   ------------------------------------------------------------------------------------------
    //9.- Метод для расчета средней длины имени
// public static Float returnAverageLengthNames(List<String> nameList) {
    //Positive Test return AVG;
    //if (nameList == null
    //nameList.isEmpty())

    @Test
    public void returnAverageLengthNamesPositiveReturnAverageTest() {
        Assertions.assertEquals(5.4F, HomeWork.returnAverageLengthNames(listName));
    }

    @Test
    public void returnAverageLengthNamesIllegalArgumentExceptionListIsNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.returnAverageLengthNames(null));
    }

    @Test
    public void returnAverageLengthNamesIllegalArgumentExceptionListIsEmptyTest() {
        listName = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.returnAverageLengthNames(listName));

    }
    //-----------------------10.createMapKeyPhoneValueName   -----------------------------------------------------------------------------------------
    // public static Map<String, String> createMapKeyPhoneValueName(List<String> stringListLines) {
    // Posit Map != null
    // Posit Map.size //размер=ожид разм
    // Posit Map.get(Key)
    //  if (listName == null IllegalArgumentException
    //  if (listName.isEmpty()) IllegalArgumentException

    // Positive Test Map != null
    @Test
    public void createMapKeyPhoneValueNamePositiveReturnMapNotNullTest() {
        Assertions.assertNotNull(HomeWork.createMapKeyPhoneValueName(stringListLines));
    }

    // Positive Test Map.size //размер=ожид разм
    @Test
    public void createMapKeyPhoneValueNamePositiveMapSizeTest() {
        assertEquals(5, HomeWork.createMapKeyPhoneValueName(stringListLines).size());
    }


    // Positive Test Map.get(Key)//правильность формирования ключей и значений
    @Test
    public void createMapKeyPhoneValueNamePositiveMapGetKeyTest() {
        assertEquals("Jose", HomeWork.createMapKeyPhoneValueName(stringListLines).get("124070157636875"));
    }

    //  if (listName == null IllegalArgumentException
    @Test
    public void createMapKeyPhoneValueNameIllegalArgumentExceptionIfListNameNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createMapKeyPhoneValueName(null));
    }

    // if (listName.isEmpty()) IllegalArgumentException
    @Test
    public void createMapKeyPhoneValueNameIllegalArgumentExceptionIfListIsEmptyTest() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.createMapKeyPhoneValueName(stringListLines));
    }


    //-----------------------11.  findContactMaxNameLength && findContactMinNameLength -----------------------------------------------------------------------------------------
//public static String findContactMaxNameLength(List<String> stringListLines) {
//public static String findContactMinNameLength(List<String> stringListLines) {
    //findContactMaxNameLength() {

    //Positive NotNullTest
    //Positive max element find Test
    //if (stringListLines == null |
    // |stringListLines.isEmpty()) {
    @Test
    public void findContactMaxNameLengthPositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.findContactMaxNameLength(stringListLines));
    }

    @Test
    public void findContactMaxNameLengthPositiveTest() {
        Assertions.assertEquals("8853301072 - Courtney Griffin MD",
                HomeWork.findContactMaxNameLength(stringListLines));
    }

    @Test
    public void findContactMaxNameLengthIllegalArgumentExceptionStringListLinesIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.findContactMaxNameLength(null));
    }

    @Test
    public void findContactMaxNameLengthIllegalArgumentExceptionStringListLinesIsEmpty() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.findContactMaxNameLength(stringListLines));
    }

    //findContactMinNameLength

    //Positive NotNullTest
    //Positive min element find Test
    //if (stringListLines == null |
    // |stringListLines.isEmpty()) {
    @Test
    public void findContactMinNameLengthPositiveNotNullTest() {
        Assertions.assertNotNull(HomeWork.findContactMinNameLength(stringListLines));
    }

    @Test
    public void findContactMinNameLengthPositiveTest() {
        Assertions.assertEquals("+1-240-701-5763x6875 - Jose Edwards",
                HomeWork.findContactMinNameLength(stringListLines));
    }

    @Test
    public void findContactMinNameLengthIllegalArgumentExceptionStringListLinesIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.findContactMinNameLength(null));
    }

    @Test
    public void findContactMinNameLengthIllegalArgumentExceptionStringListLinesIsEmpty() {
        stringListLines = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> HomeWork.findContactMinNameLength(stringListLines));
    }
}