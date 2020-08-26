package day3.ProductManage;


import day3.Enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author : liuyuwei
 * @date : 2020-08-26 18:12
 **/

//该类体现了srp设计，职责分离，使用map实现负责实例的特殊属性设置，通过Map实现
public class InstrumentSpec {
    private Map<String, Object> properties = new HashMap<>();

    public InstrumentSpec() {

    }

    public Map<String, Object> getProperties() {

        return properties;
    }

    public InstrumentType getInstrumentType() {
        return (InstrumentType) get("InstrumentType");
    }

    public InstrumentSpec setInstrumentType(InstrumentType instrumentType) {
        put(instrumentType);
        return this;
    }
    //商品类型相关属性设置
    public InstrumentClass getInstrumentClass() {

        return (InstrumentClass) get("InstrumentClass");
    }

    //分类相关属性设置
    public InstrumentClassification getInstrumentClassification() {
        return (InstrumentClassification) get("InstrumentClassification");
    }
    public InstrumentSpec setInstrumentClassification(InstrumentClassification InstrumentClassification) {
        put(InstrumentClassification);
        return this;
    }

    //品牌相关属性设置
    public InstrumentBrand getInstrumentBrand() {
        return (InstrumentBrand) get("InstrumentBrand");
    }
    public InstrumentSpec setInstrumentBrand(InstrumentBrand InstrumentBrand) {
        put(InstrumentBrand);
        return this;
    }

    //CPU相关属性设置
    public InstrumentCPU getInstrumentCPU() {
        return (InstrumentCPU) get("InstrumentCPU");
    }
    public InstrumentSpec setInstrumentCPU(InstrumentCPU InstrumentCPU) {
        put(InstrumentCPU);
        return this;
    }
    public InstrumentSpec setClass(InstrumentClass instrumentClass) {
        put(instrumentClass);
        return this;
    }

    private String getNameOf(Object property) {

        return property.getClass().getSimpleName();
    }

    Object get(String key) {

        return properties.get(key);
    }

    private void put(Object value) {

        properties.put(getNameOf(value), value);
    }

    //设计体现了srp
    boolean matches(InstrumentSpec otherSpec) {
        return otherSpec.properties
                .keySet()
                .stream()
                .allMatch(valuesMatch(otherSpec));
    }

    private Predicate<String> valuesMatch(InstrumentSpec otherSpec) {
        return otherKey -> otherSpec.get(otherKey).equals(properties.get(otherKey));
    }
}
