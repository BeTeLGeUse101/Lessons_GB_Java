//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//select * from students where name = 'Ivanov' and country = 'Russian' and city = 'Moscow'

public class Task_1 {

    private static String SortStrFromJsonStr(String json, int start, int end) {
        String name = "";
        
        if(start != -1 && end != -1) {
            name = json.substring(start, end);
        }
        return name;
    }

    private static void SQLString(String n, String country, String city, String a) {

        if (a.equals("null")) System.out.println(String.format("select * from students where name = '%s' and country = '%s' and city = '%s'", n, country, city, a));
        else System.out.println(String.format("select * from students where name = '%s' and country = '%s' and city = '%s' and age = '%s'", n, country, city, a));
    }
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String name = "";
        String country = "";
        String city = "";
        String age = "";

        int nameStartIndex = jsonString.indexOf("\"name\":\"") + 8;
        int nameEndIndex = jsonString.indexOf("\",", nameStartIndex);
        name = SortStrFromJsonStr(jsonString, nameStartIndex, nameEndIndex);

        nameStartIndex = jsonString.indexOf("\"country\":\"") + 11;
        nameEndIndex = jsonString.indexOf("\",", nameStartIndex);
        country = SortStrFromJsonStr(jsonString, nameStartIndex, nameEndIndex);

        nameStartIndex = jsonString.indexOf("\"city\":\"") + 8;
        nameEndIndex = jsonString.indexOf("\",", nameStartIndex);
        city = SortStrFromJsonStr(jsonString, nameStartIndex, nameEndIndex);

        nameStartIndex = jsonString.indexOf("\"age\":\"") + 7;
        nameEndIndex = jsonString.indexOf("\"}", nameStartIndex);
        age = SortStrFromJsonStr(jsonString, nameStartIndex, nameEndIndex);

        SQLString(name, country, city, age);
    }
}