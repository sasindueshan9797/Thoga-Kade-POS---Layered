package dao;

import dao.custom.Impl.CustomerDaoImpl;
import dao.custom.Impl.ItemDaoImpl;
import dao.custom.Impl.OrderDaoImpl;
import dao.custom.Impl.OrderDetailsDaoImpl;
import dao.util.FactoryType;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return daoFactory != null ? daoFactory : (daoFactory = new DaoFactory());
    }

    public <T extends SuperDao>T getBo(FactoryType factoryType){
        switch (factoryType){
            case CUSTOMER: return (T)new CustomerDaoImpl();
            case ITEM: return (T)new ItemDaoImpl();
            case ORDER: return (T)new OrderDaoImpl();
            case ORDER_DETAIL: return (T)new OrderDetailsDaoImpl();
        }

        return null;
    }
}
