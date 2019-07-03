package service;

public class SqlString {

    //sql for photographer
    public static String sqlRegisterPhotographer =
        "INSERT INTO `rgr`.`photographers`(`first name`,`last name`,`email photographer`, `password`)" +
                " VALUES(?,?,?,?)";

    public static String sqlUpdateProfile =
            "UPDATE `rgr`.`photographers` SET `about photographer` = ?,`price for hour` = ?," +
                    "`price for project` = ? WHERE `id photographer` = ?";

    public static String sqlDeleteProfile =
            "DELETE FROM `rgr`.`photographers` WHERE `id photographer` = ?";

    public static String sqlAuthorization = "SELECT `photographers`.`id photographer`\n" +
            "FROM `rgr`.`photographers`\n" +
            "WHERE `photographers`.`email photographer`= ? AND `photographers`.`password`=?";

    public static String sqlValidataEmail =
            "SELECT COUNT(*) FROM `rgr`.`photographers` WHERE `email photographer` = ?";

    public static String sqlGetLimitPhotographersByCat =
            "select A.`id photographer`, A.`first name`, A.`last name`, A.`price for hour`, A.`price for project`\n" +
                    "FROM photographers as A\n" +
                    "inner join attributes as B on (A.`id photographer`= B.`id photographer`)\n" +
                    "where B.`id categories` = ? \n" +
                    "ORDER BY A.`id photographer` DESC LIMIT 20 OFFSET ?";

    public static String sqlAddCatInProfile =
            "INSERT INTO `rgr`.`attributes`\n" +
                    "(`id categories`, `id photographer`)\n" +
                    "VALUES (?, ?);";

    public static String sqlDeleteCatFromProfile =
            "DELETE FROM `rgr`.`attributes`\n" +
                    "WHERE  `id photographer`= ? and attributes.`id categories`=?;";

    public static String sqlGetFullProfile =
            "SELECT `photographers`.`first name`,\n" +
                    "    `photographers`.`last name`,\n" +
                    "    `photographers`.`email photographer`,\n" +
                    "    `photographers`.`about photographer`,\n" +
                    "    `photographers`.`price for hour`,\n" +
                    "    `photographers`.`price for project`\n" +
                    "FROM `rgr`.`photographers`\n" +
                    "where `photographers`.`id photographer`=?;";

    public static String sqlGetAllCat =
            "SELECT * FROM rgr.categories";
}
