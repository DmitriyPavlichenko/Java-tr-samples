package com.company;

public class DBParamProcessor {
    public static void main(String[] args) {
        String annotatedClass = "com.company.MyDBWorker";

        try {
            Class c = Class.forName(annotatedClass);
            DBParams dbParams = (DBParams) c.getAnnotation(DBParams.class);

            System.out.println("DB name: " + dbParams.dbName());
            System.out.println("DB uid: " + dbParams.uid());
            System.out.println("DB password: " + dbParams.password());
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
