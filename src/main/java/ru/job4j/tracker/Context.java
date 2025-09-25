package ru.job4j.tracker;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private Map<String, Object> map = new HashMap<>();

    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalArgumentException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor constructor = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : constructor.getParameterTypes()) {
            if (!map.containsKey(arg.getCanonicalName())) {
                throw new IllegalArgumentException("Object not found in context : " + arg.getCanonicalName());
            }
            args.add(map.get(arg.getCanonicalName()));
        }
        try {
            map.put(cl.getCanonicalName(), constructor.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) map.get(inst.getCanonicalName());
    }
}
