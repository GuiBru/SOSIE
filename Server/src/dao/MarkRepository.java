package dao;

import Models.Mark;
import Models.StudentClassBatch;
import Models.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkRepository extends DaoBase<Mark> {

    private static final String SElECTREQUEST = "SELECT * FROM Notes ";
    public static final String TABLENAME = "Notes";
    public interface Columns{
        String ID           = "NoteId";
        String STUDENTCB    = "EleveCPId";
        String SUBJECTID    = "MatiereId";
        String VALUE        = "valeur";
    }

    private static MarkRepository instance = null;
    public static MarkRepository getInstance() {
        if(instance == null)
            instance = new MarkRepository();
        return instance;
    }

    public MarkRepository() {
        super(TABLENAME, Columns.ID);
    }

    public static Mark getById(int id) {
        ArrayList<Mark> ar = getInstance().select(SElECTREQUEST + "WHERE NoteId = " + id);
        return ar.size() > 0 ? ar.get(0) : null;
    }

    public static List<Mark> getByReverseId(Class<?> clazz, int id) {
        String column = null;
        if(clazz == Subject.class)           column = "MatiereId";
        if(clazz == StudentClassBatch.class) column = "EleveCPId";
        if(column == null) {
            System.err.println(String.format("%s.getByReverseId: Class not found : %s",
                    getInstance().getClass().getSimpleName(), clazz.getClass().getSimpleName()));
            return null;
        }
        return getInstance().select(SElECTREQUEST + "WHERE " + column + " = " + id);
    }

    public static boolean update(Integer id, String columnName, String newValue) {
        return getInstance().updateRow(columnName, newValue, id);
    }

    @Override
    public Mark dataToClass(ResultSet rs) throws SQLException {
        return new Mark(
                rs.getInt(Columns.ID),
                rs.getInt(Columns.STUDENTCB),
                rs.getInt(Columns.SUBJECTID),
                rs.getInt(Columns.VALUE)
        );
    }
}
