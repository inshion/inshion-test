package me.inshion.test.lang;

import java.util.Map;

interface RequestBuildable {

    <T> T build(Map<String, String> options);

}

interface GetModel extends RequestBuildable {

    <T> T build(Map<String, String> options);

    class DATA {

        int a;
        int b;

        public DATA(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "D [a=" + a + ", b=" + b + "]";
        }

    }

}

public class TestType {

    public static void main(String[] args) {

        GetModel g = new GetModel(){

            @SuppressWarnings("unchecked")
            @Override
            public <T> T build(Map<String, String> options) {
                // TODO Auto-generated method stub
                return (T) new DATA(0, 0);
            }
            
        };
        
       /* GetModel g1 = (o) -> {
          return null;  
        };
        
        RequestBuildable r = (o) -> {
            
        };*/

        System.out.println(g.build(null));
    }
}
