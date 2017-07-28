package edu.barsu.module.database.controller;

import com.intersys.cache.Dataholder;
import com.intersys.objects.CacheException;
import com.intersys.objects.CacheQuery;
import com.intersys.objects.CacheServerException;
import com.intersys.objects.Database;
import com.intersys.objects.reflect.CacheQueryInfo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class CloseableCacheQuery extends CacheQuery implements AutoCloseable {
    public CloseableCacheQuery(Database factory, String classname, String queryname) throws CacheException {
        super(factory, classname, queryname);
    }

    public CloseableCacheQuery(Database factory, CacheQueryInfo query) throws CacheException {
        super(factory, query);
    }

    public CloseableCacheQuery(Database factory, String sqlstatement) throws CacheException {
        super(factory, sqlstatement);
    }

    public CloseableCacheQuery(Database factory, String spName, int numParameters, int firstDefault) throws CacheException {
        super(factory, spName, numParameters, firstDefault);
    }

    @Override
    public ResultSetMetaData getMetaData() throws CacheException {
        return super.getMetaData();
    }

    @Override
    public ResultSet execute() throws CacheException {
        return super.execute();
    }

    @Override
    public ResultSet execute(Object arg1) throws CacheException {
        return super.execute(arg1);
    }

    @Override
    public ResultSet execute(Object arg1, Object arg2) throws CacheException {
        return super.execute(arg1, arg2);
    }

    @Override
    public ResultSet execute(Object arg1, Object arg2, Object arg3) throws CacheException {
        return super.execute(arg1, arg2, arg3);
    }

    @Override
    public ResultSet execute(Object[] args) throws CacheException {
        return super.execute(args);
    }

    @Override
    protected ResultSet execute(Dataholder[] args) throws CacheException {
        return super.execute(args);
    }

    @Override
    public void close() throws CacheServerException {
        super.close();
    }

    @Override
    public boolean isClosed() throws CacheServerException {
        return super.isClosed();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
