package services;


import entities.Bean;
import utils.HibernateUtil;

public abstract class AbstractService <T extends Bean> implements IService<T>{
    protected static HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final String TRANSACTION_SUCCEEDED = "Transaction succeeded";
    protected final String TRANSACTION_FAILED = "Error was thrown in service: ";
}
