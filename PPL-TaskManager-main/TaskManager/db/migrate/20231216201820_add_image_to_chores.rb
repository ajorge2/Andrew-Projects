class AddImageToChores < ActiveRecord::Migration[7.1]
  def change
    add_column :chores, :image, :string
  end
end
