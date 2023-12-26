package dao.custom.Impl;

import dao.util.CrudUtil;
import db.DBConnection;
import dto.OrderDto;
import dao.custom.OrderDetailsDao;
import dao.custom.OrderDao;
import entity.OrderDetail;
import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();


    @Override
    public Order lastOrder() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";

        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()){
            return new Order(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }

        return null;
    }


    public Order getOrder(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orders WHERE id=?";

        ResultSet resultSet = CrudUtil.execute(sql,id);

        if (resultSet.next()){
            return new Order(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }
        return null;

//        String sql = "SELECT * FROM orders WHERE id=?";
//        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
//        pstm.setString(1,id);
//        ResultSet resultSet = pstm.executeQuery();
//        if (resultSet.next()){
//            return new Order(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3)
//            );
//        }
//        return null;
    }


    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        List<OrderDetail> orderDetails = new ArrayList<>();
        Connection connection=null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO orders VALUES(?,?,?)";

            if (CrudUtil.execute(sql,entity.getId(),entity.getDate(),entity.getCustomerId())) {
                boolean isDetailSaved = orderDetailsDao.saveOrderDetails(orderDetails);
                if (isDetailSaved) {
                    connection.commit();
                    return true;
                }
            }
        }catch (SQLException | ClassNotFoundException ex){
            connection.rollback();
            ex.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            list.add(new Order(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return list;
    }
}
