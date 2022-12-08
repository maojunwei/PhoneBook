package com.maojw;
import java.util.*;
import java.util.Collections;

public class Operate {
    private List<Person> list;
    public Operate(){
        this.list = new ArrayList<>();
    }
    /**
     * addLogic() 用户添加记录业务逻辑控制
     * searchlogic() 用户查询记录业务逻辑控制
     * modifyLogic() 修改记录业务逻辑控制
     * deleteLogic()  排序记录业务控制     *
     */
    public void addLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while(true){
            menu.addMenu();
            int item = regex.menuItemValidate(1,3);
            switch(item){
                case 1: this.addOperation(); break;
                case 2: this.showAll(); break;
                case 3: return;
            }
        }

    }
    public void search(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while(true){
            menu.searchMenu();
            int item = regex.menuItemValidate(1,7);
            switch (item){
                case 1: this.searchByName();break;
                case 2: this.searchByAge();break;
                case 3: this.searchBySex();break;
                case 4: this.searchByTelNum();break;
                case 5: this.searchByAdd();break;
                case 6: this.showAll();break;
                case 7: return;
            }
        }

    }
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while(true){
            menu.modifyMenu();
            int item = regex.menuItemValidate(1,3);
            switch(item){
                case 1:this.showAll();break;
                case 2:this.modifyOperation();break;
                case 3:return;
            }
        }

    }
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while(true){
            menu.deleteMenu();
            int item = regex.menuItemValidate(1,4);
            switch(item){
                case 1:this.showAll();break;
                case 2:this.deleteOperation();break;
                case 3:this.deleteAllOperation();break;
                case 4:return;
            }
        }
    }
    public void orderLogic(){
        Menu menu = new Menu();
        Operate operate = new Operate();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.orderMenu();
            int item = regex.menuItemValidate(1,5);
            switch(item){
                case 1: this.orderName();break;
                case 2: this.orderAge();break;
                case 3: this.orderSex();break;
                case 4: this.showAll();break;
                case 5: return;
            }
        }
    }
    //
    public void addOperation(){
       TelNoteRegex regex = new TelNoteRegex();
       String name = regex.nameValidate();
       String age = regex.ageValidate();
       String sex = regex.sexValidate();
       String add = regex.addressValidate();
       String telNum = regex.telNumValidate();
       Person person = new Person(name,age,sex, telNum, add);
       this.list.add(person);
       person.setId(this.list.size());
    }
    //查询全部记录
    public void showAll(){
        if(this.list.size() == 0){
            System.out.println("当前无任何记录！");
            return;
        }
        for(int i = 0;i<this.list.size();i++){
            System.out.println(this.list.get(i).toString()); //不加toString
        }

    }
    //按姓名查找全部记录
    public void searchByName(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("按姓名查找");
        String name = regex.nameValidate();
        boolean flag = true;
        for(int i =0;i<this.list.size();i++){
            if(name.equals(this.list.get(i).getName())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("按姓名"+ name+"查找未查询到记录！");
            return;
        }
    }
    //按年龄查找记录
    public void searchByAge(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("按年龄查找");
        String age = regex.ageValidate();
        boolean flag = true;
        for(int i =0;i<this.list.size();i++){
            if(age.equals(this.list.get(i).getAge())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("按年龄"+age+"查找未查询到记录！");
            return;
        }
    }
    public void searchBySex() {
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("按性别查找");
        String sex = regex.sexValidate();
        boolean flag = true;
        for (int i = 0; i < this.list.size(); i++) {
            if (sex.equalsIgnoreCase(this.list.get(i).getSex())) {
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("按性别" + sex + "查找未查询到记录！");
            return;
        }
    }
    public void searchByTelNum(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("按电话号码查找");
        String telNum = regex.telNumValidate();
        boolean flag = true;
        for(int i =0;i<this.list.size();i++){
            if(telNum.equals(this.list.get(i).getTelNum())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag) {
            System.out.println("按电话" + telNum + "查找未查询到记录!");
            return;
        }
    }
    public void searchByAdd(){
        TelNoteRegex regex = new TelNoteRegex();
        String address = regex.addressValidate();
        boolean flag = true;
        for(int i = 0;i<this.list.size();i++){
            if(address.equalsIgnoreCase(this.list.get(i).getAddress())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("按地址"+address+"查找未查询到记录！");
        }
    }
    public void modifyOperation(){
        Menu menu = new Menu();
        while(true) {
            menu.subModifyMenu();
            TelNoteRegex regex = new TelNoteRegex();
            System.out.println("待修改记录的id:");
            int itemId = regex.menuItemValidate(1, this.list.size());
            System.out.println(this.list.get(itemId-1));
            int itemMenu = regex.menuItemValidate(1, 6);
            switch (itemMenu){
                case 1:this.list.get(itemId-1).setName(regex.nameValidate());break;
                case 2:this.list.get(itemId-1).setAge(regex.ageValidate());break;
                case 3:this.list.get(itemId-1).setSex(regex.sexValidate());break;
                case 4:this.list.get(itemId-1).setTelNum(regex.telNumValidate());break;
                case 5:this.list.get(itemId-1).setAddress(regex.addressValidate());break;
                case 6:return;
            }
        }
    }
    /**
     * 删除指定记录
     */
    public void deleteOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("请输入需要删除记录的id:");
        int itemId = regex.menuItemValidate(1, this.list.size());
        this.list.remove(itemId-1);
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
    }

    /**
     * 删除所有记录
     */
    public void deleteAllOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        this.list.clear();

    }
    //按用户年龄排序记录
    public void orderName(){
        Collections.sort(this.list,new orderByName());
        for(int i =0;i<this.list.size();i++){
            list.get(i).setId(i+1);
        }
    }
    public void orderAge(){
        Collections.sort(this.list,new orderByAge());
        for(int i =0;i<this.list.size();i++){
            list.get(i).setId(i+1);
        }
    }
    public void orderSex(){
        Collections.sort(this.list,new orderBySex());
        for(int i =0;i<this.list.size();i++){
            list.get(i).setId(i+1);
        }
    }
    /**
     * 按姓名排序的比较器
     */
    class orderByName implements Comparator<Person>{
        @Override
        public int compare(Person o1,Person o2){
            return o1.getName().compareTo(o2.getName());
        }
    }
    class orderByAge implements Comparator<Person>{
        @Override
        public int compare(Person o1,Person o2){
            return o1.getAge().compareTo(o2.getAge());
        }
    }
    class orderBySex implements Comparator<Person>{
        @Override
        public int compare(Person o1,Person o2){
            return o1.getSex().compareTo(o2.getSex());
        }
    }
}
