class TaskController < ApplicationController

  def index
    @chores = Chore.all.order(Arel.sql('datetime IS NULL, datetime'))
    @finishedChores = ChoreFinished.all
    ChoreResult.delete_all
  end

  
  def handlePost
    puts "IN HANDLE"
    if params[:commit] == "New Chore"
      addChore
    end
    if params[:commit] == "Search"
      searchChore
    end
    if params[:commit] == "View"
      viewChore
    end
    if params[:commit] == "Delete"
      deleteChore
    end
    if params[:commit] == "Complete"
      finishChore
    end
    if params[:commit] == "Clear Completed Chores"
      clearFinishedChores
    end
  end


  def clearFinishedChores
    ChoreFinished.delete_all
    respond_to do |format| 
      format.html{redirect_to "/"}
    end
  end


  def finishChore
    id = params[:id]

    chore = Chore.find(id)
    map = {"name" => chore.name, 
           "datetime" => chore.datetime, 
           "description" => chore.description, 
           "location" => chore.location, 
           "collaborators" => chore.collaborators,
           "priority" => chore.priority,
           "image" => chore.image}
    newRow = ChoreFinished.new(map)
    newRow.save

    choreToDelete = Chore.find(id.to_i).destroy

    respond_to do |format| 
      format.html{redirect_to "/"}
    end
  end


  def deleteChore
    id = params[:id]

    choreToDelete = Chore.find(id.to_i).destroy

    respond_to do |format| 
      format.html{redirect_to "/"}
    end
  end


  def viewChore
    id = params[:id]
    
    chore = Chore.find(id)
    map = {"name" => chore.name, 
           "datetime" => chore.datetime, 
           "description" => chore.description, 
           "location" => chore.location, 
           "collaborators" => chore.collaborators,
           "priority" => chore.priority}
    puts map
    puts "LOOKKKKKK HEREEE: #{ChoreResult.column_names}"
    newRow = ChoreResult.new(map)
    newRow.save

    respond_to do |format|
      format.html{redirect_to "/view"}
    end
  end
    

  def searchChore
    search_string = params[:search_string]
    
    Chore.all.each do |chore|
      if chore.name == search_string
        map = {"name" => chore.name, 
               "datetime" => chore.datetime, 
               "description" => chore.description, 
               "location" => chore.location, 
               "collaborators" => chore.collaborators,
               "priority" => chore.priority}
        puts "LOOKKKKKK HEREEE: #{ChoreResult.column_names}"
        newRow = ChoreResult.new(map)
        newRow.save
      end
    end
    
    respond_to do |format|
      format.html{redirect_to "/search"}
    end
  end


  def addChore
    priority = params[:priority]
    image_name = nil
    
    if priority == "Urgent"
      image_name = "high_priority.png"
    end
    if priority == "Regular"
      image_name = "medium_priority.png"
    end
    if priority == "Not Important"
      image_name = "low_priority.png"
    end
    
      
    map = {"name" => params[:name], 
           "datetime" => params[:datetime], 
           "description" => params[:description], 
           "location" => params[:location], 
           "collaborators" => params[:collaborators],
           "priority" => params[:priority]}
    newRow = Chore.new(map)
    newRow.save

    respond_to do |format|
        format.html{redirect_to "/"}
    end
  end
end
