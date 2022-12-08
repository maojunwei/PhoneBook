package com.maojw;
import java.util.Scanner;
/**
 * 数据校验类
 */
public class TelNoteRegex {
    /**
     * 对菜单输入项的验证
     * @param min
     * @param max
     * @return
     */
    public int menuItemValidate(int min,int max){
        //定义验证菜单项的正则表达式
        String regex = "[1-9]{1}";
        //创建键盘输入对象
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("请输入正确的数字，最小是："+min+"\t"+"最大是："+max);
            String input  = scanner.nextLine();
            if(input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if(inputNum >= min && inputNum <= max){
                    return inputNum;
                }else{
                    System.out.println("您输入的菜单项不符，请重新输入！");
                }
            }else{
                System.out.println("输入数字错误，请检查！");
            }
        }
//        return 0;
    }
    /**
     * 对用户输入姓名的验证
     * 字母长度1-10之间的
     */
    public String nameValidate(){
        //验证姓名的正则表达式
        String regex = "[a-zA-Z]{1,10}";
        //创建爱Scanner对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入用户姓名，格式为：1-10长度的大写或小写字母");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入姓名的格式错误，请重新输入！");
            }
        }
    }

    /**
     * 对用户年龄进行认证
     *数字大小在10-99之间
     * @return
     */
    public String ageValidate(){
        //对用户输入年龄的验证
        String regex = "[1-9]{1}[0-9]{1}";
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("请输入用户年龄，格式为10-99之间的数字");
            String input  = in.nextLine();
            if(input.matches(regex)){
                return input;
            }
            else{
                System.out.println("您输入年龄的格式错误，请重新输入！");
            }
        }
    }

    /**
     * 对用户性别进行认证
     * 性别的输入要求：男（m或M） 女（f 或 F）
     * @return
     */
    public String sexValidate(){
        String regex = "[m|M|f|F]{1}";
        Scanner in  = new Scanner(System.in);
        while(true){
            System.out.println("请输入您的性别，M(m)/F(f)：");
            String input = in.nextLine();
            if((input).matches(regex)){
                return input;
            }else{
                System.out.println("您输入的性别格式不正确，请重新输入");
            }
        }

    }

    /**
     * 对用户的电话号码进行验证
     * 允许带有区号的座机号，允许手机号
     * @return
     */
    public String telNumValidate(){
//        String regex = "([0-9]{4}-[1-9]{1}[0-9]{6})|([1][0-9]{10})";
        String regex = "(\\d{3,4}-\\d{7,8})|([1][0-9]{10})";
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("请输入您的手机号码，座机号或者手机号：");
            String input = in.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您输入的电话号码格式有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户的地址进行验证
     * 地址格式要求：字母或数字，长度（1,50）
     * @return
     */
    public String addressValidate(){
//        String regex = "[a-z_A-Z0-9]{1,50}";
        String regex = "[\\w]{1,50}"; //包括所有单吃字符串，数字、字母、下划线
        Scanner in =  new Scanner(System.in);
        while(true){
            System.out.println("请输入您的地址：");
            String input = in.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("你输入的地址格式有误，请重新输入！");
            }
        }
    }
    /**
     * 测试验证方法
     */
    public static void main(String[] args){
        TelNoteRegex regex = new TelNoteRegex();
        int menuItem = regex.menuItemValidate(1,6);
        System.out.println(menuItem);
    }
}

