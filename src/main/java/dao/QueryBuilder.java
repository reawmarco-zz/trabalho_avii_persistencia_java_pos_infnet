package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface QueryBuilder {

    public StringBuilder getFromStatement();

    public void setFromStatement(StringBuilder fromStatement);

    public StringBuilder getWhereStatement();

    public void setWhereStatement(StringBuilder whereStatement);

    public Map<String, Object> getParams();

    public void setParams(Map<String, Object> params);

    public String getAlias();

    public void setAlias(String alias);

    public String getFullQuery();

    public void buildQuery() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

}