Rails.application.routes.draw do
  root "task#index"
  get "/task" => "task#index"
  get "/" => "task#index"
  post "/" => "task#handlePost"

  get '/search' => "search#index"
  get '/view' => "search#index"

  # get "/search" => 
end