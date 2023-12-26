package dao.custom.Impl;

import dao.util.CrudUtil;
import db.DBConnection;
import dto.OrderDetailsDto;
import dao.custom.OrderDetailsDao;
import entity.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
    @Override
    public boolean saveOrderDetails(List<OrderDetail> list) throws SQLException, ClassNotFoundException {

        boolean isDetailsSaved = true;

        for (OrderDetail entity:list) {
            String sql = "INSERT INTO orderdetail VALUES(?,?,?,?)";


            boolean b = CrudUtil.execute(sql, entity.getOrderId(), entity.getItemCode(), entity.getQty(), entity.getUnitPrice());

            if(!(b)){
                isDetailsSaved = false;
            }
        }
        return isDetailsSaved;
    }


    @Override
    public OrderDetailsDto getOrderDetail(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orderdetail WHERE orderid=?";

        ResultSet resultSet = CrudUtil.execute(sql,id);

        if (resultSet.next()){
            return new OrderDetailsDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }



    @Override
    public boolean save(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from orderdetail WHERE orderid=?";

        return CrudUtil.execute(sql,value);
    }

    @Override
    public List<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM orderdetail";

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()){
            list.add(new OrderDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)

            ));
        }
        return list;
    }
}
