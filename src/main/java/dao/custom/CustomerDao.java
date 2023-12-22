package dao.custom;

import dao.CrudDao;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer> {
    Customer lastCustomer() throws SQLException, ClassNotFoundException;
    Customer getCustomer(String id) throws SQLException, ClassNotFoundException;
}
