package com.mygroup.countrygraphql.utils;


/**
 *
 * @author Ahmed Al Hashmi (@hashimati)
 */

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randomizer<T> {

    private Class<T> tClass ;
    private Random rnd;
    public Randomizer(Class<T> t)
    {
        this.tClass = t;
        this.rnd = new Random();
    }
    public T getRandomInstance() throws  IllegalAccessException, InstantiationException {
        T t = this.tClass.newInstance();
        List<Field> fields  = Arrays.asList(tClass.getDeclaredFields())
                .stream().filter(f-> (!f.getName().equalsIgnoreCase("id")
                        && !f.getName().equalsIgnoreCase("datecreated")
                        && !f.getName().equalsIgnoreCase("dateupdated")))
                .collect(Collectors.toList());
        for (Field f : fields) {
            f.setAccessible(true);

            if (String.class.equals(f.getType())) {
                try {

                    List<Character> charList = (IntStream.range(1, 5)
                            .boxed()
                            .map(x->new Character((char)x.intValue()))
                            .collect(Collectors.toList()));

                    StringBuilder stringBuilder = new StringBuilder();
                    while(charList.size()>0)
                    {
                        int index= rnd.nextInt(charList.size());
                        stringBuilder.append(charList.get(index));
                        charList.remove(index);
                    }
                    f.set(t, stringBuilder.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Date.class.equals(f.getType())){
                  try{
                      f.set(t, new Date());

                  }
                  catch(IllegalAccessException e)
                  {
                    e.printStackTrace();
                  }
            } else if (Character.TYPE.equals(f.getType())) {
                try {
                    f.setChar(t, (char) rnd.nextInt(100));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Byte.TYPE.equals(f.getType())) {
                try {
                    f.setByte(t, (byte) rnd.nextInt(100));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Short.TYPE.equals(f.getType())) {
                try {
                    f.setShort(t, (short) rnd.nextInt(100));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Integer.TYPE.equals(f.getType())) {
                try {
                    f.setInt(t, rnd.nextInt(100));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Long.TYPE.equals(f.getType().getName())) {
                try {
                    f.setLong(t, rnd.nextLong());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Boolean.TYPE.equals(f.getType())) {
                try {
                    f.setBoolean(t, rnd.nextBoolean());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Double.TYPE.equals(f.getType())) {
                try {
                    f.setDouble(t, rnd.nextDouble());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Float.TYPE.equals(f.getType())) {
                try {
                    f.setFloat(t, rnd.nextFloat());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.gc();
        }
        return t;
    }
}