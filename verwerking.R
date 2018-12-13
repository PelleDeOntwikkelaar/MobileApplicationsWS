library(rjson) 

print("Hello World!")

# https://blogazonia.wordpress.com/2014/05/08/import-multiple-files-to-r/

setwd("~/Json")

listfiles<-list.files(pattern=".json$")

for (i in listfiles){
    setwd("~/Json")
result <- fromJSON(file = i)

avg = result$avg
over = result$over
ontime = result$ontime

arrayst <- vector(mode="list", length=6)

arrayst[[1]] <- sum(avg)
arrayst[[2]] <- mean(avg)
arrayst[[3]] <- max(avg)
arrayst[[4]] <- min(avg)
arrayst[[5]] <- sum(over)
arrayst[[6]] <- sum(ontime)

namepath = paste(substr(i, 0, 8), "proc.json", sep="_")
    setwd("~/JsonProc")
exportJson <- toJSON(arrayst)
write(exportJson, namepath)
}

