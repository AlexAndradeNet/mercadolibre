#!/bin/zsh

production(){
    echo PRODUCCION
    mvn clean verify -Denvironment=prd
}

stagging(){
    echo STAGGING
    mvn clean verify -Denvironment=stg
}

development(){
    echo DEVELOPMENT
    mvn clean verify -Denvironment=dev
}

cleanserenity(){
    echo CLEAN SERENITY REPORT
    cd `dirname "$0"`
    cd target/site/serenity/
    rm -rf *
}

serenity(){
    echo GET SERENITY REPORT
    mvn serenity:aggregate
    open target/site/serenity/index.html
}

for ARG in $1; do
    case $ARG in
        -d|--dev)
            development
            ;;
        -s|--stg)
            stagging
            ;;
        -p|--prd)
            production
            ;;
        -c|--cleanSerenityReport)
            cleanserenity
            ;;
        -r|--getSerenityReport)
            serenity
            ;;
        *)
            echo "Unknown Argument $ARG"
            echo "Usage: sh runRobot.sh -d"
            development
            ;;
    esac
done
