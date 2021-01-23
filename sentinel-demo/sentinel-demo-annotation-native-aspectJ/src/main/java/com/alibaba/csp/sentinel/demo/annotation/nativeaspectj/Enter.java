package com.alibaba.csp.sentinel.demo.annotation.nativeaspectj;

import com.alibaba.csp.sentinel.demo.annotation.nativeaspectj.pkga.People;
import com.alibaba.csp.sentinel.demo.annotation.nativeaspectj.pkga.Person;
import com.alibaba.csp.sentinel.demo.annotation.nativeaspectj.pkgb.User;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * add the jvm parameter
 * -javaagent:D:\yourPath\aspectjweaver-1.9.6.jar
 *
 * @author shenbaoyong
 */
public class Enter {

    public static void main(String[] args) throws InterruptedException {

        initFlowRules();

        Person person = new Person();
        People people = new People();
        User user = new User();

        System.out.println();
        System.out.println("==================addPerson==================");
        System.out.println();

        for(int i = 0; i < 30; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            person.addPerson();
        }

        System.out.println();
        System.out.println("==================searchPerson==================");
        System.out.println();

        for(int i = 0; i < 30; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            person.searchPerson();
        }

        System.out.println();
        System.out.println("==================addPeople==================");
        System.out.println();

        for(int i = 0; i < 30; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            people.addPeople();
        }

        System.out.println();
        System.out.println("==================addUser==================");
        System.out.println();

        for(int i = 0; i < 30; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            user.addUser();
        }

        System.out.println();
        System.out.println("==================searchUser==================");
        System.out.println();

        for(int i = 0; i < 30; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            user.searchUser();
        }

    }

    public static void initFlowRules(){
        List<FlowRule> rules = new ArrayList();

        FlowRule rule1 = new FlowRule();
        rule1.setResource("addPersonResource");
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setCount(1);
        rules.add(rule1);

        FlowRule rule2 = new FlowRule();
        rule2.setResource("addUserResource");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);

        FlowRuleManager.loadRules(rules);

    }


}
