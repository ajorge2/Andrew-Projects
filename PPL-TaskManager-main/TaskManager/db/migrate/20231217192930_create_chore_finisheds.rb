class CreateChoreFinisheds < ActiveRecord::Migration[7.1]
  def change
    create_table :chore_finisheds do |t|
      t.string :name
      t.datetime :datetime
      t.string :description
      t.string :location
      t.string :collaborators
      t.string :image

      t.timestamps
    end
  end
end
