import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "13234sdd";
        String password = "qweee_111";
        String confirmPassword = "qweee_111";
        System.out.println(takesThreeParameters(login,password,confirmPassword));


    }

    public static boolean takesThreeParameters (String login,String password,String confirmPassword){
       try {checkLengthLogin(login);
           checkValidationCharacter(password);
           checkLengthLogin(login);
           checkLengthPassword(password);
           checkPasswordMatching(password,confirmPassword);
       }catch (WrongLoginException exception){
           System.out.println(exception.getMessage());
           return false;
       }catch (WrongPasswordException exception){
           System.out.println(exception.getMessage());
       }
       return true;
    }
    public static boolean checkValidationCharacter (String checkWord){
        if (checkWord == null){
            System.out.println("слово является null");
            return false;
        }
        if (checkWord.matches("\\w")){
        return true;
    }
        System.out.printf("Недопустимые символы в слове! - %s\n" , checkWord);
        return false;
    }
    public static boolean checkLengthLogin(String login) throws WrongLoginException{
        if (login.length() > 20){
            throw new WrongLoginException("Слишком длинный логин!");
        }
        return true;
    }
    public static boolean checkLengthPassword(String password) {
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль!");
            return false;
        }
        return true;
    }
    public static boolean checkPasswordMatching(String password,String confirmPassword)throws WrongPasswordException{
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пароли не совпалают!");
    }


}