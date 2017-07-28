package edu.barsu.module.database;

import com.intersys.objects.Database;
import com.intersys.objects.Id;

import edu.barsu.module.database.model.packages.model.*;
import edu.barsu.module.database.model.packages.structure.DepartamentSet;
import edu.barsu.module.database.model.packages.structure.clStructDepartament;
import edu.barsu.module.database.model.packages.structure.clStructPost;
import model.*;
import model.Departament;
import model.Post;

import java.util.ArrayList;

public class Util {
    public static class UEmployee {
        private static class UAdmittance {
            static clAdmittance valueOf(Admittance admittance) throws Exception {
                return new clAdmittance(
                        Integer.valueOf(admittance.getId().toString()),
                        admittance.getAdmittanceTitle(),
                        admittance.getDateGetting(),
                        admittance.getDateEnding());
            }

            static void edit(clAdmittance clAdmittance, Database dbConn) throws Exception {
                Admittance admittance = (Admittance) Admittance._open(dbConn, new Id(clAdmittance.getId()));

                admittance = convert(admittance, clAdmittance);

                admittance._save();

                dbConn.closeObject(admittance.getOref());
            }

            static Admittance addNew(clAdmittance clAdmittance, Database dbConn) throws Exception {
                Admittance admittance = new Admittance(dbConn);

                admittance = convert(admittance, clAdmittance);

                int saveCode = admittance._save();

                dbConn.closeObject(admittance.getOref());

                return (saveCode == 1) ? admittance : null;
            }

            private static Admittance convert(Admittance newAdmittance, clAdmittance oldAdmittance)
                    throws Exception {
                newAdmittance.setDateEnding(oldAdmittance.getDateEnding());
                newAdmittance.setDateGetting(oldAdmittance.getDateGetting());
                newAdmittance.setAdmittanceTitle(oldAdmittance.getAdmittanceTitle());

                return newAdmittance;
            }
        }

        private static class UAppraisal {
            static clAppraisal valueOf(Appraisal appraisal) throws Exception {
                return new clAppraisal(
                        Integer.valueOf(appraisal.getId().toString()),
                        appraisal.getPerformanceAppraisalResult(),
                        appraisal.getNextPerformanceAppraisalDate(),
                        appraisal.getPerformanceAppraisalDate());
            }

            static void edit(clAppraisal clAppraisal, Database dbConn) throws Exception {
                Appraisal appraisal = (Appraisal) Appraisal._open(dbConn, new Id(clAppraisal.getId()));

                appraisal = convert(appraisal, clAppraisal);

                appraisal._save();

                dbConn.closeObject(appraisal.getOref());
            }

            static Appraisal addNew(clAppraisal clAppraisal, Database dbConn) throws Exception {
                Appraisal appraisal = new Appraisal(dbConn);

                appraisal = convert(appraisal, clAppraisal);

                int saveCode = appraisal._save();

                dbConn.closeObject(appraisal.getOref());

                return (saveCode == 1) ? appraisal : null;
            }

            private static Appraisal convert(Appraisal newAppraisal, clAppraisal oldAppraisal)
                    throws Exception {
                newAppraisal.setNextPerformanceAppraisalDate(oldAppraisal.getNextPerformanceAppraisalDate());
                newAppraisal.setPerformanceAppraisalResult(oldAppraisal.getPerformanceAppraisalResult());
                newAppraisal.setPerformanceAppraisalDate(oldAppraisal.getPerformanceAppraisalDate());

                return newAppraisal;
            }
        }

        private static class UContract {
            static clContract valueOf(Contract contract) throws Exception {
                return new clContract(
                        Integer.valueOf(contract.getId().toString()),
                        contract.getOrderName(),
                        contract.getOrderDate(),
                        contract.getEndDate());
            }

            static void edit(clContract clContract, Database dbConn) throws Exception {
                Contract contract = (Contract) Contract._open(dbConn, new Id(clContract.getId()));

                contract = convert(contract, clContract);

                contract._save();

                dbConn.closeObject(contract.getOref());
            }

            static Contract addNew(clContract clContract, Database dbConn) throws Exception {
                Contract contract = new Contract(dbConn);

                contract = convert(contract, clContract);

                int saveCode = contract._save();

                dbConn.closeObject(contract.getOref());

                return (saveCode == 1) ? contract : null;
            }

            private static Contract convert(Contract newContract, clContract oldContract)
                    throws Exception {
                newContract.setOrderDate(oldContract.getOrderDate());
                newContract.setEndDate(oldContract.getEndDate());
                newContract.setOrderName(oldContract.getOrderName());

                return newContract;
            }
        }

        private static class UDepartament {
            static clDepartament valueOf(Departament departament) throws Exception {
                return new clDepartament(
                        Integer.valueOf(departament.getId().toString()),
                        departament.getDepartamentTitle());
            }

            static void edit(clDepartament clDepartament, Database dbConn) throws Exception {
                Departament departament = (Departament) Departament._open(dbConn, new Id(clDepartament.getId()));

                departament = convert(departament, clDepartament);

                departament._save();

                dbConn.closeObject(departament.getOref());
            }

            static Departament addNew(clDepartament clDepartament, Database dbConn) throws Exception {
                Departament departament = new Departament(dbConn);

                departament = convert(departament, clDepartament);

                int saveCode = departament._save();

                dbConn.closeObject(departament.getOref());

                return (saveCode == 1) ? departament : null;
            }

            private static Departament convert(Departament newDepartament, clDepartament oldDepartament)
                    throws Exception {
                newDepartament.setDepartamentTitle(oldDepartament.getDepartamentTitle());

                return newDepartament;
            }
        }

        private static class UExperience {
            static clExperience valueOf(Experience experience) throws Exception {
                return new clExperience(
                        Integer.valueOf(experience.getId().toString()),
                        experience.getExperiencrTitle(),
                        experience.getArmyStart(),
                        experience.getArmyEnd());
            }

            static void edit(clExperience clExperience, Database dbConn) throws Exception {
                Experience experience = (Experience) Experience._open(dbConn, new Id(clExperience.getId()));

                experience = convert(experience, clExperience);

                experience._save();

                dbConn.closeObject(experience.getOref());
            }

            static Experience addNew(clExperience clExperience, Database dbConn) throws Exception {
                Experience experience = new Experience(dbConn);

                experience = convert(experience, clExperience);

                int saveCode = experience._save();

                dbConn.closeObject(experience.getOref());

                return (saveCode == 1) ? experience : null;
            }

            private static Experience convert(Experience newExperience, clExperience oldExperience)
                    throws Exception {
                newExperience.setArmyEnd(oldExperience.getArmyEnd());
                newExperience.setArmyStart(oldExperience.getArmyStart());
                newExperience.setExperiencrTitle(oldExperience.getExperienceTitle());

                return newExperience;
            }
        }

        private static class UPost {
            static clPost valueOf(Post post) throws Exception {
                return new clPost(
                        Integer.valueOf(post.getId().toString()),
                        post.getPostTitle(),
                        post.getOrderName(),
                        post.getOrderDate(),
                        post.getFactualDate());
            }

            static void edit(clPost clPost, Database dbConn) throws Exception {
                Post post = (Post) Post._open(dbConn, new Id(clPost.getId()));

                post = convert(post, clPost);

                post._save();

                dbConn.closeObject(post.getOref());
            }

            static Post addNew(clPost clPost, Database dbConn) throws Exception {
                Post post = new Post(dbConn);

                post = convert(post, clPost);

                int saveCode = post._save();

                dbConn.closeObject(post.getOref());

                return (saveCode == 1) ? post : null;
            }

            private static Post convert(Post newPost, clPost oldPost)
                    throws Exception {
                newPost.setFactualDate(oldPost.getFactualDate());
                newPost.setOrderDate(oldPost.getOrderDate());
                newPost.setOrderName(oldPost.getOrderName());
                newPost.setPostTitle(oldPost.getPostTitle());

                return newPost;
            }
        }

        private static class URank {
            static clRank valueOf(Rank rank) throws Exception {
                return new clRank(
                        Integer.valueOf(rank.getId().toString()),
                        rank.getRankTitle(),
                        rank.getOrderName(),
                        rank.getOrderDate(),
                        rank.getFactualDate(),
                        rank.getNewRankDate());
            }

            static void edit(clRank clRank, Database dbConn) throws Exception {
                Rank rank = (Rank) Rank._open(dbConn, new Id(clRank.getId()));

                rank = convert(rank, clRank);

                rank.setRankTitle(clRank.getRankTitle());
                rank.setOrderName(clRank.getOrderName());
                rank.setOrderDate(clRank.getOrderDate());
                rank.setFactualDate(clRank.getFactualDate());
                rank.setNewRankDate(clRank.getNewRankDate());

                rank._save();

                dbConn.closeObject(rank.getOref());
            }

            static Rank addNew(clRank clRank, Database dbConn) throws Exception {
                Rank rank = new Rank(dbConn);

                rank = convert(rank, clRank);

                int saveCode = rank._save();

                dbConn.closeObject(rank.getOref());

                return (saveCode == 1) ? rank : null;
            }

            private static Rank convert(Rank newRank, clRank oldRank)
                    throws Exception {
                newRank.setRankTitle(oldRank.getRankTitle());
                newRank.setOrderName(oldRank.getOrderName());
                newRank.setOrderDate(oldRank.getOrderDate());
                newRank.setFactualDate(oldRank.getFactualDate());
                newRank.setNewRankDate(oldRank.getNewRankDate());

                return newRank;
            }
        }

        private static class USpecInspection {
            static clSpecialInspection valueOf(SpecialInspection specialInspection) throws Exception {
                return new clSpecialInspection(
                        Integer.valueOf(specialInspection.getId().toString()),
                        specialInspection.getSpecialinspectionDate());
            }

            static void edit(clSpecialInspection clSpecInspection, Database dbConn) throws Exception {
                SpecialInspection specialInspection =
                        (SpecialInspection) SpecialInspection._open(dbConn, new Id(clSpecInspection.getId()));

                specialInspection = convert(specialInspection, clSpecInspection);

                specialInspection._save();

                dbConn.closeObject(specialInspection.getOref());
            }

            static SpecialInspection addNew(clSpecialInspection clSpecInspection, Database dbConn)
                    throws Exception {
                SpecialInspection specInspection = new SpecialInspection(dbConn);

                specInspection = convert(specInspection, clSpecInspection);

                int saveCode = specInspection._save();

                dbConn.closeObject(specInspection.getOref());

                return (saveCode == 1) ? specInspection : null;
            }

            private static SpecialInspection convert(
                    SpecialInspection newInspection, clSpecialInspection oldInspection)
                    throws Exception {
                newInspection.setSpecialinspectionDate(oldInspection.getSpecialInspectionDate());

                return newInspection;
            }
        }

        public static clEmployee valueOf(Employee employee) throws Exception {
            return new clEmployee(
                    Integer.valueOf(employee.getId().toString()),
                    employee.getSurname(),
                    employee.getName(),
                    employee.getMiddleName(),
                    employee.getIndividualNumber(),
                    employee.getFileNumber(),
                    employee.getEducation(),
                    employee.getDOB(),
                    UAdmittance.valueOf(employee.getAdmittance()),
                    UAppraisal.valueOf(employee.getAppraisal()),
                    UContract.valueOf(employee.getContract()),
                    UDepartament.valueOf(employee.getDepartament()),
                    UExperience.valueOf(employee.getExperience()),
                    UPost.valueOf(employee.getPost()),
                    URank.valueOf(employee.getRank()),
                    USpecInspection.valueOf(employee.getSpecialInspection()));
        }

        public static int edit(clEmployee clEmployee, Database dbConn) throws Exception {
            Employee employee = (Employee) Employee._open(dbConn, new Id(clEmployee.getId()));

            employee = convert(employee, clEmployee);

            UAdmittance.edit(clEmployee.getAdmittance(), dbConn);
            UAppraisal.edit(clEmployee.getAppraisal(), dbConn);
            UContract.edit(clEmployee.getContract(), dbConn);
            UDepartament.edit(clEmployee.getDepartament(), dbConn);
            UExperience.edit(clEmployee.getExperience(), dbConn);
            UPost.edit(clEmployee.getPost(), dbConn);
            URank.edit(clEmployee.getRank(), dbConn);
            USpecInspection.edit(clEmployee.getSpecialInspection(), dbConn);

            int saveCode = employee._save();

            dbConn.closeObject(employee.getOref());

            return (saveCode == 1) ? 1 : 0;
        }

        public static int addNew(clEmployee clEmployee, Database dbConn) throws Exception {
            Employee employee = new Employee(dbConn);

            employee = convert(employee, clEmployee);

            employee.setAdmittance(UAdmittance.addNew(clEmployee.getAdmittance(), dbConn));
            employee.setAppraisal(UAppraisal.addNew(clEmployee.getAppraisal(), dbConn));
            employee.setContract(UContract.addNew(clEmployee.getContract(), dbConn));
            employee.setDepartament(UDepartament.addNew(clEmployee.getDepartament(), dbConn));
            employee.setExperience(UExperience.addNew(clEmployee.getExperience(), dbConn));
            employee.setPost(UPost.addNew(clEmployee.getPost(), dbConn));
            employee.setRank(URank.addNew(clEmployee.getRank(), dbConn));
            employee.setSpecialInspection(USpecInspection.addNew(clEmployee.getSpecialInspection(), dbConn));

            int saveCode = employee._save();

            dbConn.closeObject(employee.getOref());

            return saveCode;
        }

        private static Employee convert(Employee newEmployee, clEmployee oldEmployee)
                throws Exception {
            newEmployee.setSurname(oldEmployee.getSurName());
            newEmployee.setName(oldEmployee.getName());
            newEmployee.setMiddleName(oldEmployee.getMiddleName());
            newEmployee.setIndividualNumber(oldEmployee.getIndividualNumber());
            newEmployee.setFileNumber(oldEmployee.getFileNumber());
            newEmployee.setDOB(oldEmployee.getDob());
            newEmployee.setEducation(oldEmployee.getEducation());

            return newEmployee;
        }
    }

    public static class UStructDepartament {
        private static class UStructPost {
            private static clStructPost valueOf(structure.Post post)
                    throws Exception {
                return new clStructPost(post.getTitle(),
                        post.getAmount(),
                        post.getRankLimit());
            }
        }

        public static clStructDepartament valueOf(structure.Departament departament, ArrayList<structure.Post> postList)
                throws Exception {
            ArrayList<clStructPost> structPostList = new ArrayList<clStructPost>(postList.size());
            for (structure.Post post: postList)
                structPostList.add(UStructPost.valueOf(post));

            return new clStructDepartament(departament.getTtile(), structPostList);
        }
    }

    public static class UDepartamentSet {
        public static DepartamentSet getDepartamentSet(ArrayList<clStructDepartament> departamentList) {
            return new DepartamentSet(departamentList);
        }
    }
}
